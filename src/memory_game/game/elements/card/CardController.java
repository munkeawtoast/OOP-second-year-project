/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Dimension;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import memory_game.game.util.*;

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
    
    private void triggerGood() {
        new Thread(() -> {
            TransitionPlayer up = view.getUpTransition();
            TransitionPlayer good = view.getFadeTransition(); // bad
            if (!view.getIsAnimating()) {
                synchronized (up) {
                    up.start();
                }
            }
            synchronized(good) {
                good.start();
            }
            view.setIsAnimating(false);
        }).start();
    }
    
    private void triggerBad() {
        new Thread(() -> {
            TransitionPlayer up = view.getUpTransition();
            TransitionPlayer shake = view.getShakeTransition();
            TransitionPlayer down = view.getDownTransition();
            if (!view.getIsAnimating()) {
                synchronized (this) {
                    up.start();
                }    
            }
            synchronized(this) {
                shake.start();
            }
//            synchronized(this) {
//                down.start();
//            }
            view.setIsAnimating(false);
        }).start();
    }
    
    private void triggerPick() {
        System.out.println(view.getIsAnimating());
        if (view.getIsAnimating()) { return; }
        view.setIsAnimating(true);
        view.getUpTransition().start();
        
    }
     
     public void runAnimation(String type) {
        
        switch(type) {
            case ANIM_GOOD -> {
                triggerGood();
            }
            case ANIM_BAD -> {
                triggerBad();
            }
            case ANIM_PICK -> {
                triggerPick();
            }
        }
    }
    
    public boolean isPair(CardController cardController) {
        return this.getModel().getPair() == cardController.getModel();
    }
    
    //TODO
}
