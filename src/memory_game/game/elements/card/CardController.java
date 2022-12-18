/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class CardController {
    public static final String ANIM_GOOD = "animation-good";
    public static final String ANIM_BAD = "animation-bad";
    public static final String ANIM_PICK = "animation-pick";
    
    
    private Card model;
    private CardView view;

    public CardController(String cardName, Dimension size, ImageIcon frontImage, ImageIcon backImage) {
        model = new Card(cardName, size, backImage, backImage);
        view = new CardView(this);
    }

    public Card getModel() {
        return model;
    }

    public CardView getView() {
        return view;
    }
    
    public void triggerGood() {
        
    }
    
    public void triggerBad() {
        
    }
    
    public void triggerSelect() {
        
    }
    
    public void runAnimation(String type) {
        int percent = 0;
        int time;
        switch(type) {
            case ANIM_PICK -> {
                view.animateUp();
                
            }
        }
    }
    
    public boolean isPair(CardController cardController) {
        return this.getModel().getPair() == cardController.getModel();
    }
    
    //TODO
}
