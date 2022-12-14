/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class CardController {
    private Card model;
    private CardView view;

    public CardController(Card model) {
        this.model = model;
        this.view = new CardView(new Dimension(250, 250), new ImageIcon("resources/images/return.png"));
    }
    
    public void handleCardAction() {
       try {
           flip();
       } catch (Exception ignored) {}
    }
    
    public Thread getFlipperInstance() {
        Thread cardFlipper = new Thread(() -> {
            Dimension initialSize = view.getSize();
            boolean initialState = model.getIsFlipped();
            Timer timer = new Timer(1, null);
            // 0-249: 0 deg -> 90deg, 250-499: 90deg -> 180deg
            model.setFlipSize(0);
            // count adder listener
            timer.addActionListener(() -> {
                if (model.getFlipSize() <= 250) {
                    view.setCardSize(
                            new Dimension(
                                    initialSize.width * ((250-model.getFlipSize()) / 250),
                                    initialSize.height
                            )
                    );
                    if (model.getFlipSize() == 250) {
                        if (initialState == true) {
                            view.setCardImage(model.getBackImage());
                        } else {
                            view.setCardImage(model.getFrontImage());
                        }
                    }
                } else if (model.getFlipSize()  <= 500) {
                    view.setCardSize(
                            new Dimension(
                                    initialSize.width * ((model.getFlipSize()-250) / 250),
                                    initialSize.height
                            )
                    );
                    if (model.getFlipSize() == 500) {
                        model.setFlipSize(0);
                        model.setIsFlipped(!initialState);
                        model.setIsFlipping(false);
                        timer.stop();
                    }
                } 
                model.setFlipSize(model.getFlipSize()+1);
            });
        });
        return cardFlipper;
    }
    
    public void flip() throws Exception {
        if (model.getIsFlipping()) {
            throw new Exception("Card is flipping.");
        }
        model.setIsFlipping(true);
        getFlipperInstance().start();
    }
}
