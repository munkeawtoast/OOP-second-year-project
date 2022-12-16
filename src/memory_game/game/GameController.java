
package memory_game.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;


public class GameController implements WindowListener, ActionListener {
    private JFrame frame;
    private Game model;
    private List<IGameView> views;

    
    /**
     * @param playerName
     * @param difficulty difficulty: Game.EASY, game.MEDIUM, game.HARD 
     * @param frame window frame for setting window operation
     */
    public GameController(String playerName, int difficulty, JFrame frame) {
        this.frame = frame;
        frame.addWindowListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new Game(playerName, difficulty);
        views = new ArrayList<>();
        views.add(new GameLoggerView(this));
        views.add(new GameGUIView(this));
        this.initialize();
    }
    
    private synchronized void initialize() {
        model.initialize();
        
        // register clicks
        for (CardController cardController : model.getCardList()) {
            cardController.getView().addActionListener(this);
        }
        
        // initialize each views
        for (IGameView view : views) {
            view.initialize();
            
            view.handleGameStart();
        }
        
        
    }

    
    public GameLoggerView getLogger() {
        return (GameLoggerView) views.get(0);
    }
    
    public GameGUIView getGUIView() {
        return (GameGUIView) views.get(1);
    }
    
    public Game getModel() {
        return model;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof CardView) {
            if (model.getPredict1() == null) {
                
            } else if (model.getPredict2() == null) {
                
            }
        }
    }
    
}