
package memory_game.game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import memory_game.GameFrame;
import memory_game.Panel.Alert;
import memory_game.Sound.Sound;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;
import memory_game.game.elements.timer.TimerController;


public class GameController implements WindowListener, ActionListener {
    
    private GameFrame frame;
    private Game model;
    private List<IGameView> views;
    private boolean cardpair;
 
    
    int winnum;
    
    /**
     * @param playerName
     * @param difficulty difficulty: Game.EASY, game.MEDIUM, game.HARD 
     * @param frame window frame for setting window operation
     */
    public GameController(String playerName, int difficulty, GameFrame frame) {
        this.frame = frame;
        frame.addWindowListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new Game(playerName, difficulty);
        views = new ArrayList<>();
        views.add(new GameLoggerView(this));
        views.add(new GameGUIView(this));
        this.initialize();
        getGUIView().getTimepanel().add(model.getTimer().getView());
        
        
        
       
       
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
            
                 
            frame.playCardSound();
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
                    getGUIView().getScore().setText(model.getScore()+"");
                    frame.playCorrectSound();
                    cardpair = true;
//                   
                } else {
                    currentAnim = CardController.ANIM_BAD;
                    model.setScore(model.getScore() - model.getScoreDecrease());
                    getGUIView().getScore().setText(model.getScore()+"");
                    frame.playWrongSound();
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
   
    public void winCheck(){
        if(cardpair){
            winnum++;
        }
        if(winnum == model.getWinnum()){
          
            model.getTimer().stopTime();
              String time = model.getTimer().getView().getText();
              if(model.getScore() > 0 ){
              frame.getBoard().getModel().addToList(model);
            
              frame.getBoard().updateBoard(frame.getBoard().getModel().getList());
              frame.alert("You Win!!   Score: " + model.getScore() );
              }
              else{
                  frame.alert("You Lose T^T    Try Again?");
              }
            
        }
        
      
    }
   
    }
    
