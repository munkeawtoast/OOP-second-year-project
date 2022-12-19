/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;


import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import memory_game.game.util.*;

public class CardView extends JButton {
    public static final Dimension SMALL = new Dimension(70, 93);
    public static final Dimension MEDIUM = new Dimension(80, 106);
    public static final Dimension LARGE = new Dimension(90, 120);
    
    private CardController controller;
    private Card model;
    private boolean isAnimating = false;
    private boolean isHover = false;

    public CardView(CardController cardController) {
        super(cardController.getModel().getImageBack());
        this.setDisabledIcon(cardController.getModel().getImageFront());
        this.controller = cardController;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        setContentAreaFilled(false);
//        setPreferredSize(new Dimension(200, 300));
        this.controller = cardController;
        this.model = cardController.getModel();
    }
    
    public TransitionPlayer getFadeTransition() {
        return new TransitionPlayer(this, Transition.SHAKE, Transition.OPACITY, 250, 1);
    }
    
    public TransitionPlayer getShakeTransition() {
        return new TransitionPlayer(this, Transition.SHAKE, Transition.EAST, 100, 30);
    }
    
    public TransitionPlayer getUpTransition() {
        return new TransitionPlayer(this, Transition.EASE_IN_SINE, Transition.NORTH, 250, 30);
    }
    public TransitionPlayer getDownTransition() {
        return new TransitionPlayer(this, Transition.EASE_IN_SINE, Transition.SOUTH, 250, 30);
    }
    
    public void setIsAnimating(boolean isAnimating) {
        this.isAnimating = isAnimating;
    }
    
    public boolean getIsAnimating() {
        return isAnimating;
    }

    public CardController getController() {
        return controller;
    }
    
    public void changeToFront() {
        setIcon(controller.getModel().getImageFront());
    }
    
    public void changeToBack() {
        setIcon(controller.getModel().getImageBack());
    }
}
    
