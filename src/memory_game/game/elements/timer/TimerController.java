
package memory_game.game.elements.timer;

public class TimerController {
    MyTimer model;
    TimerView view;

    public TimerController() {
        view = new TimerView();
        model = new MyTimer((ignored) -> {
            view.setTime(model.getTimeElapsed());
        });
    }


    
    
}
