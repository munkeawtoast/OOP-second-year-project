/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game;

/**
 *
 * @author Gungai
 */
import memory_game.Panel.StartMenu;
import memory_game.Panel.Menu;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import memory_game.Panel.EasyPanel;
import memory_game.Panel.InsertName;
import memory_game.Panel.LeaderBoard.LeaderBoardController;
import memory_game.Panel.NormalPanel;
import memory_game.game.Game;
import memory_game.game.GameController;
import memory_game.game.Player;

// what is this? -Pine
// i think project should only have one main function -Pine
public class Frame extends JFrame implements ActionListener {
    String mode;
    JFrame f;
    Menu menu = new Menu();
    StartMenu startmenu = new StartMenu();
    InsertName insertname = new InsertName();
    GameController game;
    LeaderBoardController board = new LeaderBoardController();

    public Frame() {
        
       

        setVisible(true);
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menu);
        setSize(800,600);
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public StartMenu getStartmenu() {
        return startmenu;
    }

    public void setStartmenu(StartMenu startmenu) {
        this.startmenu = startmenu;
    }

    public InsertName getInsertname() {
        return insertname;
    }

    public void setInsertname(InsertName insertname) {
        this.insertname = insertname;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
//           exit byn click
            System.exit(0);

        } else if (e.getActionCommand().equals("Start")) {
//           start btn click

            setContentPane(insertname);
            pack();

        } else if (e.getActionCommand().equals("Easy")) {
//           Easy btn click
            loadGame(insertname.getName(), Game.EASY);
         
           

        } else if (e.getActionCommand().equals("Leaderboard")) {
             setContentPane(board.getView());
            pack();
//           leaderboard btn click

        } else if (e.getActionCommand().equals("Normal")) {
//           normal btn click
            
        } else if (e.getActionCommand().equals("Hard")) {
//           hard btn click
        } else if (e.getActionCommand().equals("Next")) {
            
            setContentPane(startmenu);
           pack();

        } else if (e.getActionCommand().equals("return1")) {
            setContentPane(menu);
            invalidate();
            validate();
        } else if (e.getActionCommand().equals("return2")) {
            setContentPane(insertname);
            invalidate();
            validate();
        } else if (e.getActionCommand().equals("return3")) {
            setContentPane(menu);
            invalidate();
            validate();
        }
        
        else if (e.getActionCommand().equals("Restart")){
          
           
        }
        else if (e.getActionCommand().equals("Tomenu")){
          
           
                    
        }

    }
     public void loadGame(String name, int difficulty) {
        game = new GameController(name, difficulty, this);
        setContentPane(game.getGUIView());
        pack();
    }
}
