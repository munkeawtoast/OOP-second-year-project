/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game;

/**
 *
 * @author Gungai
 */
import memory_game.mainmenu.StartMenu;
import memory_game.mainmenu.Menu;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// what is this? -Pine
// i think project should only have one main function -Pine

public class Frame implements ActionListener {
    JFrame f;
    Menu menu;
    StartMenu startmenu;
    public Frame(){
        f = new JFrame("POKEMON MEMORY CARD GAME");
        f.setSize(800,600);
        menu = new Menu();
        f.add(menu);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          StartMenu startmenu = new StartMenu();
         
        menu.getStartBtn().addActionListener(this);
        menu.getLeaderBtn().addActionListener(this);
        menu.getExitBtn().addActionListener(this);
    }
    public static void main(String[] args) {
        new Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(menu.getExitBtn())){
           System.exit(0);
       }
       if(e.getSource().equals(menu.getStartBtn())){
           menu.add(startmenu);
       }
    
}
}
