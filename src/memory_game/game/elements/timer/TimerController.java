
package memory_game.game.elements.timer;

import java.io.Serializable;


public class TimerController implements Serializable{
    MyTimer model;
    TimerView view;

    public TimerController() {
        view = new TimerView();

        model = new MyTimer((ignored) -> {
            view.setTime(model.getFormattedTime());
        });
    }
    
    public TimerView getView(){
        return this.view;
    }
    public MyTimer getTimeModel(){
        return this.model;
    }
    public void stopTime(){
        model.stopTime();
    }


    
    
}
