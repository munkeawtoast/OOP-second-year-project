/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.card;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class Card {
    private static int cardCount = 1;
    private int id;
    private Card pair;
    private boolean isFlipped;
    private int flipSize;
    private boolean isFlipping;
    private String name;
    private ImageIcon image;
    private ImageIcon backImage;

    public Card(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
//        this.backImage = new ImageIcon(); // ADD BACKIMAGE
        this.backImage = new ImageIcon("resources/images/return2.png");
        id = Card.cardCount;
        Card.cardCount++;
    }

    void setIsFlipped(boolean isFlipped) {
        this.isFlipped = isFlipped;
    }

    void setIsFlipping(boolean isFlipping) {
        this.isFlipping = isFlipping;
    }
    
    boolean getIsFlipping() {
        return isFlipping;
    }
    
    boolean getIsFlipped() {
        return isFlipped;
    }
    
    int getFlipSize() {
        return flipSize;
    }
    
    void setFlipSize(int size) {
        this.flipSize = size;
    }
    
    ImageIcon getFrontImage() {
        return image;
    }
    
    ImageIcon getBackImage() {
        return backImage;
    }
}