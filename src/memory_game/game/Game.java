
package memory_game.game;

import java.util.ArrayList;
import java.util.List;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.timer.TimerController;


    
public class Game {
    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int  HARD = 2;
    
    private String playerName;
    private int difficulty;
    private List<CardController> cardList;
    private TimerController timer;
    private CardController predict1, predict2;
    private boolean animationIsRunning;

    public Game(String playerName, int difficulty) {
        this.playerName = playerName;
        this.difficulty = difficulty;
        this.cardList = new ArrayList<>();
        timer = new TimerController();
    }
    
    public void initialize() {
        
        switch(difficulty) {
            case EASY -> {
                
            }
            case MEDIUM -> {
                
            }
            case HARD -> {
                
            }
                
        }
    }

    public int getDifficulty() {
        return difficulty;
    }

    public TimerController getTimerController() {
        return timer;
    }
    
    public List<CardController> getCardList() {
        return cardList;
    }
    
    
}
