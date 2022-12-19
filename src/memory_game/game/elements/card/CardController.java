/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Dimension;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import memory_game.Sound.Sound;
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
    Sound clicksound;

    public CardController(String cardName, Dimension size, ImageIcon frontImage, ImageIcon backImage) {
        model = new Card(cardName, size, frontImage, backImage);
        view = new CardView(this);
    }
    

    public Card getModel() {
        return model;
    }

    public CardView getView() {
        return view;
    }
    
    public void setPair(Card card) {
        model.setPair(card);
    }
    
    private void triggerGood() {
        view.setEnabled(false);
        new Thread(() -> {
            view.changeToFront();
            TransitionPlayer up = view.getUpTransition();
            TransitionPlayer down = view.getDownTransition();
            view.changeToFront();
            if (!view.getIsAnimating()) {
                up.start();
                try {
                    up.join(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Thread temp = new Thread(() -> {
                    while (true) {}
                });
                temp.start();
                try {
                    temp.join(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            Thread temp = new Thread(() -> {
                while (true) {}
            });
            temp.start();
            try {
                temp.join(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            down.start();
            try {
                down.join(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.changeToFront();
            view.setIsAnimating(false);
        }).start();
    }
    
    private void triggerBad() {
        view.setEnabled(false);
        new Thread(() -> {
            view.changeToFront();
            TransitionPlayer up = view.getUpTransition();
            TransitionPlayer shake = view.getShakeTransition();
            TransitionPlayer down = view.getDownTransition();
            if (!view.getIsAnimating()) {
                up.start();
                try {
                    up.join(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Thread temp = new Thread(() -> {
                    while (true) {}
                });
                temp.start();
                try {
                    temp.join(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            shake.start();
            try {
                shake.join(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            down.start();
            try {
                down.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.changeToBack();
            view.setIsAnimating(false);
            view.setEnabled(true);
        }).start();
    }
    
    private void triggerPick() {
        view.setEnabled(false);
        if (view.getIsAnimating()) { return; }
        view.setIsAnimating(true);
        view.changeToFront(); ///////////////////////////////////////////////////////
        view.getUpTransition().start();
        view.setEnabled(true);
        
        
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
