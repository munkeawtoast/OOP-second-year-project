
package memory_game.game.elements.timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;


// normal text doesn't work ;-;
public class TimerPixel extends JComponent{
    private boolean isOn;
    private Point intialPosition = new Point(-1, -1);
    private Color color;

    public TimerPixel(boolean isOn) {
        toggle(isOn);
        setPreferredSize(new Dimension(4, 4));
        
    }
    
    public void initialize() {
        
        setInitialPosition(this.getLocation());
        new Thread(){
            @Override
            public void run(){
                try {
                    color = new Color(0,0,0,0);
                    Thread.sleep(850);
                  
                     color = new Color(0,0,0);
                     repaint();
                       
                } catch (Exception ex) {
                    Logger.getLogger(TimerPixel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
       
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    public void setInitialPosition(Point p) {
        intialPosition = p;
    }
    
    public void toggle(boolean value) {
        isOn = value;
        if (isOn) {
            if (!this.intialPosition.equals(new Point(-1, -1))) {
                this.setLocation(intialPosition);
            }
        } else {
            this.setLocation(999999999, 999999999);
        }
    }
    public TimerPixel getTimerPixel(){
        return this;
    }
    
    
    
}
