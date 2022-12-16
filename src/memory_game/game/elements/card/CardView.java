/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;


import javax.swing.JButton;

public class CardView extends JButton {
    private Card model;
    private boolean isAnimating = false;

    public CardView(Card model) {
        this.model = model;
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
    
