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
import memory_game.mainmenu.EasyPanel;
import memory_game.mainmenu.InsertName;

// what is this? -Pine
// i think project should only have one main function -Pine
public class Frame implements ActionListener {

    JFrame f;
    Menu menu  = new Menu();
    StartMenu startmenu = new StartMenu();
    InsertName insertname = new InsertName();
    
    public Frame() {
        f = new JFrame("POKEMON MEMORY CARD GAME");
        f.setSize(800, 600);

        f.add(menu);
        
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        insertname.getNextBtn().addActionListener(this);
        insertname.getReturnBtn().addActionListener(this);
        menu.getStartBtn().addActionListener(this);
        menu.getLeaderBtn().addActionListener(this);
        menu.getExitBtn().addActionListener(this);
        startmenu.getEasyBtn().addActionListener(this);
        startmenu.getNormalBtn().addActionListener(this);
        startmenu.getHardBtn().addActionListener(this);
        startmenu.getReturnBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
//           exit byn click
            System.exit(0);

        } else if (e.getActionCommand().equals("Start")) {
//           start btn click

            f.setContentPane(insertname);
            f.invalidate();
            f.validate();

        } else if (e.getActionCommand().equals("Easy")) {
//           Easy btn click
 java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //do animation here if want
                //sleep here
                EasyPanel easy = new EasyPanel();
                 f.setContentPane(easy);
            f.invalidate();
            f.validate();
            }
        });
            
           

        } else if (e.getActionCommand().equals("Leaderboard")) {
//           leaderboard btn click

        } else if (e.getActionCommand().equals("Normal")) {
//           normal btn click
        } else if (e.getActionCommand().equals("Hard")) {
//           hard btn click
        } else if (e.getActionCommand().equals("Next")) {

            f.setContentPane(startmenu);
            f.invalidate();
            f.validate();

        } else if (e.getActionCommand().equals("return1")) {
            f.setContentPane(menu);
            f.invalidate();
            f.validate();
        } else if (e.getActionCommand().equals("return2")) {
            f.setContentPane(insertname);
            f.invalidate();
            f.validate();
        }

    }
}
