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
public class Card {
    private static int cardCount = 1;
    private int id;
    private Card pair;
    private boolean isFlipped;
    private String name;
    private ImageIcon image;

    public Card(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
        id = Card.cardCount;
        Card.cardCount++;
    }
        
}