    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package memory_game.game.util;

import java.awt.Point;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JComponent;

    /**
     *
     * @author munkeawtoast
     */
    public class TransitionPlayer extends Thread {
        private JComponent target;
        private int transition;
        private int duration;
        private int direction;
        private int amount;
        private int elapsedDuration;
        private double elapsedPercentage;
        private boolean isPaused;
        private Point initialPosition;

        public TransitionPlayer(JComponent target, int transition, int direction , int duration, int amount) {
            this.target = target;
            this.transition = transition;
            this.direction = direction;
            this.duration = duration;
            this.amount = amount;
            this.initialPosition = target.getLocation();
        }
        
        protected synchronized void checkPaused() {
            while (isPaused) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TransitionPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        public synchronized void resumeAnimation() {
            isPaused = false;
            this.notify();
        }

        public void pauseAnimation() {
            isPaused = true;
        }
        
        private void moveTarget(int translateAmount) {
            switch (direction) {
                case Transition.UP -> target.setLocation(target.getX(), initialPosition.y - translateAmount);
                case Transition.RIGHT -> target.setLocation(initialPosition.x + translateAmount, target.getY());
                case Transition.DOWN -> target.setLocation(target.getX(), initialPosition.y + translateAmount);
                case Transition.LEFT -> target.setLocation(initialPosition.x - translateAmount, target.getY());
            }
//            target.repaint();
        }

        @Override
        public void run() {
            try {
                while (elapsedPercentage < 1) {
                    checkPaused();
                    elapsedDuration += 1;
                    elapsedPercentage = (double) elapsedDuration / (double) duration;
                    int translateAmount = 0;

                    switch(transition) {
                        case (Transition.EASE_IN_OUT_CUBIC) -> {
                            
                            double translatePercentage = Transition.easeInOutCubic(elapsedPercentage);
                            translateAmount = (int) (translatePercentage * amount);
                        }
                    }
                    // TODO
                    moveTarget(translateAmount);
                    System.out.println(elapsedPercentage);


                    this.sleep(1);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TransitionPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public double getElapsedPercentage() {
            return elapsedPercentage;
        }

        public int getElapsedDuration() {
            return elapsedDuration;
        }
    }
