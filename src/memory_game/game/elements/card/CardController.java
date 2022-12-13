/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

/**
 *
 * @author ACER
 */
public class CardController {
    private Card model;
    private CardView view;

    public CardController(Card model, CardView view) {
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
