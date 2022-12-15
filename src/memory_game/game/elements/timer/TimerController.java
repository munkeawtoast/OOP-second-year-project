
package memory_game.game.elements.timer;

import javax.swing.JLabel;

public class TimerController {
    MyTimer model;
    TimerView view;

    public TimerController() {
        view = new TimerView();
        model = new MyTimer((ignored) -> {
            view.setTime(model.getTimeElapsed());
        });
    }
    public JLabel getTimeLabel(){
        return this.view;
    }
    public MyTimer getTimeModel(){
        return this.model;
    }
    public void stopTime(){
        model.stopTime();
    }


    
    
}
