/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Dimension;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class Card implements Serializable {
    private static int cardCount = 1;
   
    private Card pair;
   
    private String name;
    private ImageIcon imageFront;
    private ImageIcon imageBack;

    public Card(String name, Dimension size, ImageIcon imageFront, ImageIcon imageBack) {
        this.name = name;
        Image iFront = imageFront.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        Image iBack = imageBack.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        
        this.imageFront = new ImageIcon(iFront);
        this.imageBack = new ImageIcon(iBack);
        
       
        Card.cardCount++;
 
    }

    public void setPair(Card pair) {
        this.pair = pair;
    }

    public Card getPair() {
        return pair;
    }

    public ImageIcon getImageBack() {
        return imageBack;
    }

    public ImageIcon getImageFront() {
        return imageFront;
    }
   
    
        
}