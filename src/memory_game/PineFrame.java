/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game;

import javax.swing.JFrame;
import memory_game.game.Game;
import memory_game.game.GameController;

/**
 *
 * @author munkeawtoast
 */
public class PineFrame extends JFrame {
    GameController game;
    public PineFrame() {
        super("MemoryGame");

        loadGame("eiei", Game.EASY);

        

        
        setVisible(true);
    }
    
    public void loadGame(String name, int difficulty) {
        game = new GameController(name, difficulty, this);
        setContentPane(game.getGUIView());
        pack();
    }
}
