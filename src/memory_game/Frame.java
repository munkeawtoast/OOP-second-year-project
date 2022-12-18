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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import memory_game.Panel.EasyPanel;
import memory_game.Panel.InsertName;
import memory_game.Panel.LeaderBoard.LeaderBoardController;
import memory_game.Panel.NormalPanel;
import memory_game.Sound.Sound;
import memory_game.game.Game;
import memory_game.game.GameController;
import memory_game.game.Player;

// what is this? -Pine
// i think project should only have one main function -Pine
public class Frame extends JFrame implements ActionListener {

    Menu menu = new Menu();
    StartMenu startmenu = new StartMenu();
    InsertName insertname = new InsertName();
    GameController game;
    LeaderBoardController board = new LeaderBoardController();
    Sound clicksound;
    Sound backclicksound;
    Sound bgsound;

    public Frame() {
        setTitle("Pokemon Matching Card Game");
        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menu);
        setSize(800, 600);
        insertname.getNextBtn().addActionListener(this);
        insertname.getReturnBtn().addActionListener(this);
        menu.getStartBtn().addActionListener(this);
        menu.getLeaderBtn().addActionListener(this);
        menu.getExitBtn().addActionListener(this);
        startmenu.getEasyBtn().addActionListener(this);
        startmenu.getNormalBtn().addActionListener(this);
        startmenu.getHardBtn().addActionListener(this);
        startmenu.getReturnBtn().addActionListener(this);
        board.getView().getReturnBtn().addActionListener(this);
        try {
            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/music.wav"));
            // Get the audio format and create a new Clip object
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);

            // Open the audio file and start playing it
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Set the volume to 50%
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float gain = 0.3f;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        ArrayList<Game> players = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            players.add(new Game("game", 2));
            players.get(i).setScore(i + 10);
        }
        board.updateBoard(players);

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
            new Thread() {
                @Override
                public void run() {
                    try {
                        clicksound = new Sound(getClass().getResource("/sounds/click.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(clicksound.getSamples());
                    clicksound.play(stream);
                }
            }.start();//clicksound
//           exit byn click
            System.exit(0);

        } else if (e.getActionCommand().equals("Start")) {
//           start btn click
            new Thread() {
                @Override
                public void run() {
                    try {
                        clicksound = new Sound(getClass().getResource("/sounds/click.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(clicksound.getSamples());
                    clicksound.play(stream);
                }
            }.start();//clicksound
            setContentPane(insertname);
            pack();

        } else if (e.getActionCommand().equals("Easy")) {
//           Easy btn click
            loadGame(insertname.getName(), Game.EASY);

        } else if (e.getActionCommand().equals("Leaderboard")) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        clicksound = new Sound(getClass().getResource("/sounds/click.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(clicksound.getSamples());
                    clicksound.play(stream);
                }
            }.start();//clicksound
            setContentPane(board.getView());
            pack();
//           leaderboard btn click

        } else if (e.getActionCommand().equals("Normal")) {
//           normal btn click

        } else if (e.getActionCommand().equals("Hard")) {
//           hard btn click
        } else if (e.getActionCommand().equals("Next")) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        clicksound = new Sound(getClass().getResource("/sounds/click.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(clicksound.getSamples());
                    clicksound.play(stream);
                }
            }.start();//clicksound

            setContentPane(startmenu);
            pack();

        } else if (e.getActionCommand().equals("return1")) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        backclicksound = new Sound(getClass().getResource("/sounds/backclick.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(backclicksound.getSamples());
                    backclicksound.play(stream);
                }
            }.start();//returnclicksound
            setContentPane(menu);
            invalidate();
            validate();
        } else if (e.getActionCommand().equals("return2")) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        backclicksound = new Sound(getClass().getResource("/sounds/backclick.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(backclicksound.getSamples());
                    backclicksound.play(stream);
                }
            }.start();//clicksound
            setContentPane(insertname);
            invalidate();
            validate();

        } else if (e.getActionCommand().equals("Restart")) {

        } else if (e.getActionCommand().equals("Tomenu")) {

        }

    }

    public void loadGame(String name, int difficulty) {
        game = new GameController(name, difficulty, this);
        setContentPane(game.getGUIView());
        pack();
    }
}
