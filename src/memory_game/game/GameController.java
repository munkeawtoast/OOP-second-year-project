
package memory_game.game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

import memory_game.GameFrame;

import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;



public class GameController implements ActionListener {
    
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
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new Game(playerName, difficulty);
        views = new ArrayList<>();
        views.add(new GameLoggerView(this));
        views.add(new GameGUIView(this));
        
     
        
        
        
       
       
    }
    
    public synchronized void initialize() {
//        try{new Thread(){
//            @Override
//            public void run(){
//                  getGUIView().getTimepanel().add(model.getTimer().getView());
//                  
//            }
//            
//        }.start();}
//        catch(Exception e){
//            e.printStackTrace();
//        }
        
      
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
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof CardView cardView) {
          
                 
            frame.playCardSound();
            CardController cardController = cardView.getController();
            
            if (cardController == model.getPredict1()) { return; }
            
            if (model.getPredict1() == null) {
                model.setPredict1(cardController);
                model.getPredict1().getView().setIgnoreRepaint(true);
                model.getPredict1().runAnimation(CardController.ANIM_PICK);
               
            } else if (model.getPredict2() == null) {
                model.setPredict2(cardController);
                model.getPredict2().getView().setIgnoreRepaint(true);
                String currentAnim;
                
                if (model.getPredict1().isPair(model.getPredict2())) {
                    currentAnim = CardController.ANIM_GOOD;
                    model.setScore(model.getScore()+model.getScoreIncrease());
                    System.out.println("Score + " + model.getScoreIncrease());
                   
//                    getGUIView().setScore(model.getScore());
getGUIView().getScoreView().setnumber(model.getScore());
getGUIView().getScoreView().repaint();
                    frame.playCorrectSound();
                    cardpair = true;
//                   
                } else {
                    currentAnim = CardController.ANIM_BAD;
                    model.setScore(model.getScore() - model.getScoreDecrease());
                   
//                    getGUIView().setScore(model.getScore());
                        getGUIView().getScoreView().setnumber(model.getScore());
                        getGUIView().getScoreView().repaint();
                     
                    frame.playWrongSound();
                    System.out.println("Score - " + model.getScoreDecrease());
                    cardpair = false;
                }
                model.getPredict1().runAnimation(currentAnim);
                model.getPredict2().runAnimation(currentAnim);
                model.setPredict1(null);
                model.setPredict2(null);
               
                winCheck();
                
                
            }
        }
    }
   
    public void winCheck(){
        if(cardpair){
            winnum++;
        }
        if(winnum == model.getWinnum()){
          
            model.getTimer().stopTime();
              
              if(model.getScore() > 0 ){
              frame.getBoard().getModel().addToList(model);
              frame.getBoard().updateBoard(frame.getBoard().getModel().getList());
              frame.stopMusic();
              frame.playWinMusic();
              frame.alert("You Win!!   Score: " + model.getScore() );
              }
              else{
                  frame.alert("You Lose T^T    Try Again?");
              }
            
        }
        
      
    }
   
    }
    
