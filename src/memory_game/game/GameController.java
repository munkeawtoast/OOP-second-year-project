
package memory_game.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;


public class GameController implements ActionListener {
    private Game model;
    private List<IGameView> views;

    
    /**
     * @param playerName
     * @param difficulty difficulty: Game.EASY, game.MEDIUM, game.HARD 
     */
    public GameController(String playerName, int difficulty) {
        model = new Game(playerName, difficulty);
        views = new ArrayList<>();
        views.add(new GameLoggerView(model));
        views.add(new GameGUIView(model));
        this.initialize();
    }
    
    private void initialize() {
        // register clicks
        for (CardController cardController : model.getCardList()) {
            cardController.getView().addActionListener(this);
        }
        
        // initialize each views
        views.forEach(view -> {
            view.initialize();
            
            view.handleGameStart();
        });
        
        
    }

    
    public GameLoggerView getLogger() {
        return (GameLoggerView) views.get(0);
    }
    
    public GameGUIView getGUIView() {
        return (GameGUIView) views.get(0);
    }
    
    public Game getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // wtf wtf wtf what should i do
        if (e.getSource() instanceof CardView) {
            
        }
        if (model.getPredict1() == null) {
            model.setPredict1((e.getSource());
        } else if (model.getPredict2() == null) {
            model.setPredict2(e.getSource());
        }
    }
    
        
    
}
