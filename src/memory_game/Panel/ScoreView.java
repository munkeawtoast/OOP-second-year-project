/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel;

/**
 *
 * @author thanakorn
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class ScoreView extends JPanel {
   Font pixelFont_24;
    private int number;
    

    public ScoreView() {
        super();
        setOpaque(false);
        setPreferredSize(new Dimension(60,30));
           try {
           pixelFont_24 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")));
      
       } catch (FontFormatException ex) {
           Logger.getLogger(ScoreView.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(ScoreView.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setFont(pixelFont_24);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(number), 5, 25);
    }
    
    public void setnumber(int number){
        
        this.number = number;
    }
    
    
}