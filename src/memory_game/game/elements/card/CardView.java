/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;


import javax.swing.JButton;

public class CardView extends JButton {
    private CardController controller;
    private Card model;
    private boolean isAnimating = false;

    public CardView(CardController cardController) {
        super(cardController.getModel().getImageBack());
        this.controller = cardController;
        this.model = cardController.getModel();
    }
    
    public void animateFlip() {
        
    }
    
    public void animatePair() {
        
    }

    public void setIsAnimating(boolean isAnimating) {
        this.isAnimating = isAnimating;
    }
    
    public boolean getIsAnimating() {
        return isAnimating;
    }
}
    
