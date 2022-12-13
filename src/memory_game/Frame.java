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
import memory_game.mainmenu.InsertName;

// what is this? -Pine
// i think project should only have one main function -Pine

public class Frame implements ActionListener {
    JFrame f;
    Menu menu;
    StartMenu startmenu;
    InsertName insertname;
    public Frame(){
        f = new JFrame("POKEMON MEMORY CARD GAME");
        f.setSize(800,600);
        menu = new Menu();
        f.add(menu);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
         
        menu.getStartBtn().addActionListener(this);
        menu.getLeaderBtn().addActionListener(this);
        menu.getExitBtn().addActionListener(this);
    }
 

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Exit")){
//           exit byn click
           System.exit(0);
            
       }
       else if(e.getActionCommand().equals("Start")){
//           start btn click
            InsertName insertname = new InsertName();
            insertname.getNextBtn().addActionListener(this);
            insertname.getReturnBtn().addActionListener(this);
            f.setContentPane(insertname);
            f.invalidate();
            f.validate();
         
       }
       else if (e.getActionCommand().equals("Easy")){
//           Easy btn click
      
       }
       else if (e.getActionCommand().equals("Leaderboard")){
//           leaderboard btn click
           
       }
       else if (e.getActionCommand().equals("Normal")){
//           normal btn click
       }
       else if (e.getActionCommand().equals("Hard")){
//           hard btn click
       }
       else if (e.getActionCommand().equals("Next")){
            
            StartMenu startmenu = new StartMenu();
            f.setContentPane(startmenu);
            f.invalidate();
            f.validate();
            startmenu.getEasyBtn().addActionListener(this);
            startmenu.getNormalBtn().addActionListener(this);
            startmenu.getHardBtn().addActionListener(this);
       }
       else if (e.getActionCommand().equals("return1")){
           f.setContentPane(menu);
            f.invalidate();
            f.validate();
       }
       
       
    
}
}
