/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game;

import java.awt.FontFormatException;
import javax.swing.JFrame;
import memory_game.game.GameController;

/**
 *
 * @author munkeawtoast
 */
public class TestFrame extends JFrame {

    public TestFrame() throws FontFormatException {
        super();
        GameFrame a = new GameFrame();
        setContentPane(new GameController("A", 0, a).getGUIView());
        a.stopMusic();
        a.dispose();
        pack();
        setVisible(true);
        
        
    }
    
}
