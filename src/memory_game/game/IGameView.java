/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game;

import memory_game.game.elements.card.CardController;

/**
 *
 * @author munkeawtoast
 */
public interface IGameView {
    
    public void initialize();
    
    public void handleClickWhenAnim();
    
    public void handleCorrect(CardController card);
    
    public void handleWrong(CardController card);
    
    public void handleGameStart();
    
    public void handleGameEnd();
}
