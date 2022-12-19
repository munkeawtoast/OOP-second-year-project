
package memory_game.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import memory_game.Panel.Alert;
import memory_game.Sound.Sound;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;


public class GameController implements WindowListener, ActionListener {
    private Alert alert;
    private JFrame frame;
    private Game model;
    private List<IGameView> views;
    private boolean cardpair;
    Sound clicksound;
    int winnum;
    
    /**
     * @param playerName
     * @param difficulty difficulty: Game.EASY, game.MEDIUM, game.HARD 
     * @param frame window frame for setting window operation
     */
    public GameController(String playerName, int difficulty, JFrame frame) {
        alert = new Alert();
        alert.setVisible(false);
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
        
        if (e.getSource() instanceof CardView cardView) {
            
                 
            playClickSound();
            CardController cardController = cardView.getController();
            
            if (cardController == model.getPredict1()) { return; }
            
            if (model.getPredict1() == null) {
                model.setPredict1(cardController);
                model.getPredict1().runAnimation(CardController.ANIM_PICK);
               
            } else if (model.getPredict2() == null) {
                model.setPredict2(cardController);
                String currentAnim;
                
                if (model.getPredict1().isPair(model.getPredict2())) {
                    currentAnim = CardController.ANIM_GOOD;
                    model.setScore(model.getScore()+model.getScoreIncrease());
                    System.out.println("Score + " + model.getScoreIncrease());
                    cardpair = true;
//                   
                } else {
                    currentAnim = CardController.ANIM_BAD;
                    model.setScore(model.getScore() - model.getScoreDecrease());
                    playWrongSound();
                    System.out.println("Score - " + model.getScoreDecrease());
                    cardpair = false;
                }
                model.getPredict1().runAnimation(currentAnim);
                model.getPredict2().runAnimation(currentAnim);
                model.setPredict1(null);
                model.setPredict2(null);
                winCheck();
                System.out.println("Player Name: " + model.getPlayerName()+ "Score: "+ model.getScore());
                
            }
        }
    }
    public void playClickSound(){
         new Thread() {
                @Override
                public void run() {
                    try {
                        clicksound = new Sound(getClass().getResource("/sounds/card.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(clicksound.getSamples());
                    clicksound.play(stream);
                }
            }.start();
    }
    public void playWrongSound(){
         new Thread() {
                @Override
                public void run() {
                   
                    try {
                       Thread.sleep(300);
                        clicksound = new Sound(getClass().getResource("/sounds/wrong.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(clicksound.getSamples());
                    clicksound.play(stream);
                }
            }.start();
    }
    public void winCheck(){
        if(cardpair){
            winnum++;
        }
        if(winnum == model.getWinnum()){
            System.out.println("You Win eiei");
            model.getTimer().stopTime();
            alert.setVisible(true);
            alert.getScoreLabel().setText("You Win!! Score:" + model.getScore() + "Time: " +model.getTimer().getView().getText());
         
        }
        
      
    }
    public Alert getAlert(){
        
        return this.alert;
        
    }
    }
    
