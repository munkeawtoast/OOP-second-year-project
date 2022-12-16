
package memory_game.game;

import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
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
    private int Score;
    private boolean animationIsRunning;

    public Game(String playerName, int difficulty) {
        this.playerName = playerName;
        this.difficulty = difficulty;
        this.cardList = new ArrayList<>();
        timer = new TimerController();
    }
    
    public void initialize() {
        List<Integer> intList;
        ImageIcon frontImage, backImage;
        int count;
        Dimension gridSize = new Dimension();
        switch(difficulty) {
            case EASY -> {
                count = 3*4/2;
                gridSize = new Dimension(4, 3);
            }
            case MEDIUM -> {
                count = 4*5/2;
                gridSize = new Dimension(5, 4);
            }
            case HARD -> {
                count = 5*6/2;
                gridSize = new Dimension(6, 5);
            }
        }
        
        
        // add to cardList
        intList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            intList.add(i);
            frontImage = new ImageIcon(getClass().getResource("/images/card0.jpg"));
            backImage = new ImageIcon(getClass().getResource("/images/backcard.png"));
            cardList.add(new CardController("test" + i + "0", gridSize, frontImage, backImage));
            cardList.add(new CardController("test" + i + "1", gridSize, frontImage, backImage));
        }
        
        Collections.shuffle(intList);
        
    }

    public int getScore() {
        return Score;
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

    public void setPredict1(CardController predict1) {
        this.predict1 = predict1;
    }

    public void setPredict2(CardController predict2) {
        this.predict2 = predict2;
    }

    public CardController getPredict1() {
        return predict1;
    }

    public CardController getPredict2() {
        return predict2;
    }

    public String getPlayerName() {
        return playerName;
    }

    public TimerController getTimer() {
        return timer;
    }
    
    
    
    
    
    
}
