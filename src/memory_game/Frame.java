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
import memory_game.Panel.NormalPanel;
import memory_game.game.Player;

// what is this? -Pine
// i think project should only have one main function -Pine
public class Frame implements ActionListener {
    String mode;
    JFrame f;
    Menu menu = new Menu();
    StartMenu startmenu = new StartMenu();
    InsertName insertname = new InsertName();
    Player p;
    EasyPanel easy;
    NormalPanel normal;

    public Frame() {
        f = new JFrame("POKEMON MEMORY CARD GAME");
        f.setSize(800, 600);
        p = new Player();
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

            f.setContentPane(insertname);
            f.invalidate();
            f.validate();

        } else if (e.getActionCommand().equals("Easy")) {
//           Easy btn click
            mode = "easy";
                    
                    easy = new EasyPanel();
                    easy.getAlert().getRestartBtn().addActionListener(this);
                    easy.getAlert().getExtiBtn().addActionListener(this);
                    f.setContentPane(easy);
                    f.invalidate();
                    f.validate();
//                      if (easy.isWon()) {
//                        String endtime = easy.getTimeController().getTimeLabel().getText();
//                        System.out.println(endtime);
//                       easy.getAlert().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                       easy.getAlert().setVisible(true);
//                     
//                        
////                        JOptionPane.showMessageDialog(gamePanel, "You Won! Your Score is " + scoree);
//                           
////                        initGame();
//                    }
           

        } else if (e.getActionCommand().equals("Leaderboard")) {
//           leaderboard btn click

        } else if (e.getActionCommand().equals("Normal")) {
//           normal btn click
            mode = "normal";
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //do animation here if want
                    //sleep here
                    NormalPanel normal = new NormalPanel();
                    f.setContentPane(normal);
                    f.invalidate();
                    f.validate();
                }
            });
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
        else if (e.getActionCommand().equals("Restart")){
            if(mode.equals("easy")){
                    p.setScore(easy.getScoree());
                    p.setTime(easy.getTimeController().getView().getTimeLabel().getText());
                    easy = new EasyPanel();
                    easy.getAlert().getRestartBtn().addActionListener(this);
                    easy.getAlert().getExtiBtn().addActionListener(this);
                    easy.getAlert().setVisible(false);
                    f.setContentPane(easy);
                    f.invalidate();
                    f.validate();
                    
            }
            p.setMode(mode);
            p.setName(insertname.getNameTF().getText());
            System.out.println(p);
           
        }
        else if (e.getActionCommand().equals("Tomenu")){
            p.setMode(mode);
            p.setName(insertname.getNameTF().getText());
             if(mode.equals("easy")){
                p.setScore(easy.getScoree());
                p.setTime(easy.getTimeController().getView().getTimeLabel().getText());
            }
            else if (mode.equals("normal")){
                p.setScore(normal.getScoree());
                p.setTime(normal.getTimeController().getView().getTimeLabel().getText());
            }
            else if (mode.equals("hard")){
                
            }
            f.setContentPane(menu);
            f.invalidate();
            f.validate();
             System.out.println(p);
           
                    
        }

    }
}
