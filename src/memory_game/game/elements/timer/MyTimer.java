
package memory_game.game.elements.timer;


import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MyTimer extends Timer{
    private int timeElapsed;
    
    public MyTimer(ActionListener taskPerformer) {
        super(1000, taskPerformer);
        super.addActionListener(e -> {
            timeElapsed += 1;
        });
        start();
    }

    int getTimeElapsed() {
        return timeElapsed;
    }
    
    
}
