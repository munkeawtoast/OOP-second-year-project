/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class CardController {
    private Card model;
    private CardView view;

    public CardController(String cardName, Dimension size, ImageIcon frontImage, ImageIcon backImage) {
        model = new Card(cardName, size, backImage, backImage);
        view = new CardView(model);
    }

    public Card getModel() {
        return model;
    }

    public CardView getView() {
        return view;
    }
    
    public void triggerClickAnim() {
        
    }
    
    //TODO
}
