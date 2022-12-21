
package memory_game.game.elements.timer;


import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MyTimer extends Timer{
    private int timeElapsed ;
    
    public MyTimer(ActionListener taskPerformer) {
        super(1000, taskPerformer);
        super.addActionListener(e -> {
            timeElapsed += 1;
        });
        start();
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }
    public void stopTime(){
        this.stop();
        
    }
    
    public String getFormattedTime() {
        
        int minutes = timeElapsed / 60;
        int seconds = timeElapsed % 60;
        return String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }
}
