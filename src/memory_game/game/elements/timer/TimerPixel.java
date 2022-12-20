
package memory_game.game.elements.timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JComponent;


// normal text doesn't work ;-;
public class TimerPixel extends JComponent{
    private boolean isOn;
    private Point intialPosition;

    public TimerPixel(boolean isOn) {
        toggle(isOn);
        setPreferredSize(new Dimension(4, 4));
        setBackground(Color.black);
    }
    
    public void initialize() {
        setInitialPosition((this.getLocation()));
    }
    
    public void setInitialPosition(Point p) {
        intialPosition = p;
    }
    
    public void toggle(boolean value) {
        isOn = value;
        if (isOn) {
            this.setLocation(intialPosition);
        } else {
            this.setLocation(999999999, 999999999);
        }
    }
    
    
    
}
