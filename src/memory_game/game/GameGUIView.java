
package memory_game.game;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.timer.TimerView;


public class GameGUIView extends JPanel implements IGameView {
    private GameController gameController;
    private Game game;
    private JPanel cardGrid;
    private TimerView timer;
    private JLabel scoreLabel;

    public GameGUIView(GameController gameController) {
        this.gameController = gameController;
        this.game = gameController.getModel();
        this.timer = game.getTimerController().getView();
    }
    
    @Override
    public void initialize() {
        cardGrid = new JPanel();
        switch (game.getDifficulty()) {
            case Game.EASY -> {
                cardGrid.setLayout(new GridLayout(4, 3));
            }
            case Game.MEDIUM -> {
                cardGrid.setLayout(new GridLayout(5, 4));
            }
            case Game.HARD -> {
                cardGrid.setLayout(new GridLayout(6, 5));
            }
        }
        
        for (CardController cardController : game.getCardList()) {
            cardGrid.add(cardController.getView());
        }
        
        this.add(cardGrid);
    }
    
    @Override
    public void handleClickWhenAnim() {
        
    }

    @Override
    public void handleCorrect(CardController card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleWrong(CardController card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleGameStart() {}

    @Override
    public void handleGameEnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
