
package memory_game.game;

import java.awt.Dimension;
import java.io.Serializable;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;
import memory_game.game.elements.timer.TimerController;



public class Game implements Comparable<Game>, Serializable{
    public static final int TEST = -1;
    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;
    
    
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
        int count = 0;
        switch(difficulty) {
            case TEST -> {
                count = 1;
            }
            case EASY -> {
                count = 3*4/2;
            }
            case MEDIUM -> {
                count = 4*5/2;
            }
            case HARD -> {
                count = 5*6/2;
            }
            default -> {
                throw new InvalidParameterException("Must be TEST, EASY, MEDIUM or HARD!");
            }
        }
        
        
        // create cardList
        int[] intArray = IntStream.range(0, 15).toArray();
        intList = new ArrayList<>();
        for (int i : intArray) {
            intList.add(i);
        }
        
        // shuffle and cut
        Collections.shuffle(intList);
        intList = intList.subList(0, count);
        
        for (int i : intList) {
            System.out.println(i);
            frontImage = new ImageIcon(getClass().getResource("/images/card"+i+".jpg"));
            backImage = new ImageIcon(getClass().getResource("/images/backcard.png"));
            CardController cardController1 = new CardController("test" + i + "0", CardView.MEDIUM, frontImage, backImage);
            CardController cardController2 = new CardController("test" + i + "0", CardView.MEDIUM, frontImage, backImage);
            cardController1.setPair(cardController2.getModel());
            cardController2.setPair(cardController1.getModel());
            cardList.add(cardController1);
            cardList.add(cardController2);
            Collections.shuffle(cardList);
        }
        
        
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

    
    @Override
    public int compareTo(Game other) {
        return other.Score - this.Score;
    }
    
    public void setScore(int score){
        if(score<0){
            this.Score = 0;
        }
        
    else{
        this.Score = score;
}
    }
    @Override
    public String toString(){
        return "Name: "+ this.getPlayerName();
    }
    
    
}
