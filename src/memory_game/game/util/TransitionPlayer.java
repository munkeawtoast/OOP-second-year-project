    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package memory_game.game.util;

    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JComponent;

    /**
     *
     * @author munkeawtoast
     */
    public class TransitionPlayer extends Thread {
        public static final int UP = 0;
        public static final int RIGHT = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;
        private JComponent target;
        private int transition;
        private int duration;
        private int direction;
        private int elapsedDuration;
        private double elapsedPercentage;
        private boolean isPaused;

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

        public TransitionPlayer(JComponent target, int transition, int direction , int duration) {
            this.target = target;
            this.transition = transition;
            this.direction = direction;
            this.duration = duration;
        }
        
        private void moveTarget(int translateAmount) {
            switch (direction) {
                case UP -> target.setLocation(target.getX(), target.getY() - translateAmount);
                case RIGHT -> target.setLocation(target.getX() + translateAmount, target.getY());
                case DOWN -> target.setLocation(target.getX(), target.getY() + translateAmount);
                case LEFT -> target.setLocation(target.getX() - translateAmount, target.getY());
            }
//            target.repaint();
        }

        @Override
        public void run() {
            try {
                while (elapsedPercentage < 100) {
                    checkPaused();
                    elapsedDuration += 1;
                    elapsedPercentage = elapsedDuration / duration;
                    int translateAmount = 0;

                    switch(transition) {
                        case (Transition.EASE_IN_OUT_CUBIC) -> {
                            translateAmount = (int) Transition.easeInOutCubic(elapsedPercentage);
                        }
                    }
                    // TODO
                    moveTarget(translateAmount);
                    System.out.println(elapsedPercentage);


                    this.sleep(10);
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
