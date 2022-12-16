/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class CardController {
    private Card model;
    private CardView view;

    public CardController(ImageIcon frontImage, ImageIcon backImage) {
        this.model = model;
        this.view = view;
    }

    public Card getModel() {
        return model;
    }

    public CardView getView() {
        return view;
    }
    
    //TODO
}
