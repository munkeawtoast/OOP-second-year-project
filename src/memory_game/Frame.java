/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game;

/**
 *
 * @author Gungai
 */
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import memory_game.Panel.StartMenu;
import memory_game.Panel.Menu;


import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import memory_game.Panel.Alert;

import memory_game.Panel.InsertName;
import memory_game.Panel.LeaderBoard.LeaderBoardController;

import memory_game.Sound.Sound;
import memory_game.game.Game;
import memory_game.game.GameController;

// what is this? -Pine
// i think project should only have one main function -Pine
public class Frame extends JFrame implements ActionListener, WindowListener {

    Menu menu = new Menu();
    StartMenu startmenu = new StartMenu();
    InsertName insertname = new InsertName();
    GameController game;
    LeaderBoardController board = new LeaderBoardController();
    Sound clicksound;
    private int gamemode;
    Font pixelFont_30;
    Font pixelFont_24;
    Clip clip;

    public Frame() throws FontFormatException {
        //add new font 
        	try{
            // load a custom font in your project folder
			pixelFont_30 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(30f);
                        pixelFont_24 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(24f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
        
        
        playBackgroundMusic();
        setTitle("Pokemon Matching Card Game");

        setVisible(true);
        setResizable(false);
        addWindowListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menu);
        setSize(800, 600);
        this.setLocationRelativeTo(null);
       
        insertname.getNameTF().setFont(pixelFont_30);
        insertname.getJLabel().setFont(pixelFont_30);
        board.getView().getTable().setFont(pixelFont_24);
        board.getView().getTable().getTableHeader().setFont(pixelFont_30);
        board.getView().getHeaderText().setFont(pixelFont_30);
        
         
        menu.getMutebtn().addActionListener(this);
        board.getView().getReturnBtn().addActionListener(this);
        menu.getUnmutebtn().addActionListener(this);
        insertname.getNextBtn().addActionListener(this);
        insertname.getReturnBtn().addActionListener(this);
        menu.getStartBtn().addActionListener(this);
        menu.getLeaderBtn().addActionListener(this);
        menu.getExitBtn().addActionListener(this);
        startmenu.getEasyBtn().addActionListener(this);
        startmenu.getNormalBtn().addActionListener(this);
        startmenu.getHardBtn().addActionListener(this);
        startmenu.getReturnBtn().addActionListener(this);

//        TEST BOARD FUNCTION
//        ArrayList<Game> players = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            players.add(new Game("game", 2));
//            players.get(i).setScore(i + 10);
//        }
//        board.updateBoard(players);
//            Game test = new Game("EIEIE", 1);
//            test.setScore(300);
//           board.getModel().addList(test);
//           board.updateBoard(board.getModel().getList());
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {

//           exit byn click

            
            playClickSound();
            ArrayList<Game> games = board.getModel().getList();
            try ( FileOutputStream fos = new FileOutputStream("LeaderBoard.dat");  ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(board.getModel().getList());
                System.out.println("save successfull");
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            System.exit(0);

        } else if (e.getActionCommand().equals("Start")) {
//           start btn click
            playClickSound();
            setContentPane(insertname);
            pack();

        } else if (e.getActionCommand().equals("Easy")) {

//           Easy btn click
            gamemode = Game.EASY;
            loadGame(insertname.getNameTF().getText(), gamemode);
            System.out.println("eie");

        } else if (e.getActionCommand().equals("Leaderboard")) {
            playClickSound();
            setContentPane(board.getView());
            pack();
//           leaderboard btn click

        } else if (e.getActionCommand().equals("Normal")) {
            gamemode = Game.MEDIUM;
            playClickSound();
            loadGame(insertname.getNameTF().getText(), gamemode);
//           normal btn click

        } else if (e.getActionCommand().equals("Hard")) {
            gamemode = Game.HARD;
            //           hard btn click
            playClickSound();
            loadGame(insertname.getNameTF().getText(), gamemode);

        } else if (e.getActionCommand().equals("Next")) {
            playClickSound();
            if (!insertname.getNameTF().getText().equals("")) {
                setContentPane(startmenu);
                pack();
            } else {
                JOptionPane.showMessageDialog(insertname, "Insert Your Name!!");
            }

        } else if (e.getActionCommand().equals("return1")) {
            playBackClickSound();
            setContentPane(menu);
            invalidate();
            validate();
        } else if (e.getActionCommand().equals("return2")) {
            playBackClickSound();
            setContentPane(insertname);
            invalidate();
            validate();

        } else if (e.getActionCommand().equals("Restart")) {
            System.out.println("restart");
            board.getModel().addToList(game.getModel());
            board.updateBoard(board.getModel().getList());
            remove(game.getGUIView());
            loadGame(insertname.getNameTF().getText(), gamemode);

        } else if (e.getActionCommand().equals("Tomenu")) {
            board.getModel().addToList(game.getModel());
            board.updateBoard(board.getModel().getList());
            setContentPane(menu);
            remove(game.getGUIView());

            pack();

        } else if (e.getActionCommand().equals("mute")) {
            System.out.println("Mute");
            muteMusic();
        }
         else if (e.getActionCommand().equals("unmute")) {
            unMuteMusic();
            System.out.println("Unmute");
        }

    }

    public void loadGame(String name, int difficulty) {
        game = new GameController(name, difficulty, this);

        setContentPane(game.getGUIView());
        pack();
        game.getAlert().getRestartBtn().addActionListener(this);
        game.getAlert().getExtiBtn().addActionListener(this);
        game.getGUIView().getJLabel().setFont(pixelFont_24);
        game.getGUIView().getJLabel2().setFont(pixelFont_24);
        game.getGUIView().getScore().setFont(pixelFont_24);
        
        game.getModel().getTimer().getView().setFont(pixelFont_24);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        File f = new File("LeaderBoard.dat");
        if (f.exists()) {
            System.out.println("Board data found");
            try ( FileInputStream fis = new FileInputStream(f);  ObjectInputStream ois = new ObjectInputStream(fis)) {
                ArrayList<Game> savelist = (ArrayList<Game>) ois.readObject();

                board.updateBoard(savelist);
                fis.close();
                ois.close();
            } catch (IOException ie) {
                System.out.println("An error occurred while reading from the file: " + ie);
            } catch (ClassNotFoundException ce) {
                System.out.println("Class not found: " + ce);
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ArrayList<Game> games = board.getModel().getList();
        try ( FileOutputStream fos = new FileOutputStream("LeaderBoard.dat");  ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(board.getModel().getList());
            System.out.println("save successfull");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public void playClickSound() {
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
    }

    public void playBackClickSound() {
        new Thread() {
            @Override
            public void run() {
                try {
                    clicksound = new Sound(getClass().getResource("/sounds/backclick.wav"));
                } catch (Exception e) {
                }
                InputStream stream
                        = new ByteArrayInputStream(clicksound.getSamples());
                clicksound.play(stream);
            }
        }.start();//clicksound
    }

    public void playBackgroundMusic() {
        try {
            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/music.wav"));
            // Get the audio format and create a new Clip object
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);

            // Open the audio file and start playing it
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

         

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void stopMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void muteMusic() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float gain = 0.0f;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
    public void unMuteMusic() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float gain = 1f;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
}
