
package memory_game.game.elements.timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


// normal text doesn't work ;-;
public class TimerPixel extends JPanel{
    private boolean isOn;
    private Point intialPosition;

    public TimerPixel(boolean isOn) {
//        toggle(isOn);
        this.isOn = isOn;
        setSize(new Dimension(4, 4));
        
        SwingUtilities.invokeLater(() -> {
            setInitialPosition(this.getLocation());
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
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
