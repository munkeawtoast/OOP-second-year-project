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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import memory_game.Panel.StartMenu;
import memory_game.Panel.Menu;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Random;
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
import memory_game.game.Player;

// what is this? -Pine
// i think project should only have one main function -Pine
public class GameFrame extends JFrame implements ActionListener, WindowListener,Serializable {
    private Thread gameThread;
    private Thread Clicksound;
    private Thread BackClickSound;
    private Thread WrongSound;
    private Thread CorrectSound;
    private Thread CardSound;
    private Thread StartSound;
    Menu menu = new Menu();
    StartMenu startmenu = new StartMenu();
    InsertName insertname = new InsertName();
    GameController game;
    LeaderBoardController board = new LeaderBoardController();
    Sound sound;
    private int gamemode;
    Font pixelFont_30;
    Font pixelFont_24;
  
    Font pixelFont_44;
    Clip clip;
    Alert alert;

    public GameFrame() {
        alert = new Alert();
        //add new font 
        try {
            // load a custom font in your project folder
            pixelFont_30 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(30f);
            pixelFont_24 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(24f);
            pixelFont_44 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(44f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")));
        } catch (IOException | FontFormatException e) {

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

        insertname.getNameTF().setFont(pixelFont_24);
        insertname.getJLabel().setFont(pixelFont_44);
        board.getView().getTable().setFont(pixelFont_24);
        board.getView().getTable().getTableHeader().setFont(pixelFont_30);
        board.getView().getHeaderText().setFont(pixelFont_44);
        startmenu.getHeaderLabel().setFont(pixelFont_44);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {

//           exit byn click
            playClickSound();
            saveLeaderBoard();
            System.exit(0);

        } else if (e.getActionCommand().equals("Start")) {
//           start btn click
            playClickSound();
            insertname.getNameTF().setText("");
            setContentPane(insertname);
            invalidate();
            validate();
            pack();

        } else if (e.getActionCommand().equals("Easy")) {

//           Easy btn click
            playStartSound();
            gamemode = Game.EASY;
            loadGame(insertname.getNameTF().getText(), gamemode);
            System.out.println("eie");

        } else if (e.getActionCommand().equals("Leaderboard")) {
            playClickSound();
            setContentPane(board.getView());
            invalidate();
            validate();
            pack();
//           leaderboard btn click

        } else if (e.getActionCommand().equals("Normal")) {
            gamemode = Game.MEDIUM;
            playStartSound();
            loadGame(insertname.getNameTF().getText(), gamemode);
//           normal btn click

        } else if (e.getActionCommand().equals("Hard")) {
            gamemode = Game.HARD;
            //           hard btn click
            playStartSound();
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
            remove(game.getGUIView());
            playClickSound();
            playBackgroundMusic();
            alert.setVisible(false);
            
            loadGame(insertname.getNameTF().getText(), gamemode);

        } else if (e.getActionCommand().equals("Tomenu")) {
            playClickSound();

            playBackgroundMusic();
            alert.setVisible(false);
            remove(game.getGUIView());
            setContentPane(menu);
          
            invalidate();
            validate();
            
       

        } else if (e.getActionCommand().equals("mute")) {
            System.out.println("Mute");
            muteMusic();
        } else if (e.getActionCommand().equals("unmute")) {
            unMuteMusic();
            System.out.println("Unmute");
        }

    }

    public void loadGame(String name, int difficulty) {
        stopMusic();
        playGameMusic();
    // 
    
    if (gameThread != null) {
        gameThread.interrupt();
    }
    //
    gameThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                createGameController(name, difficulty);

                setContentPane(game.getGUIView());
                game.initialize();
                invalidate();
                validate();
                pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    gameThread.start();
}
    private void createGameController(String name, int difficulty){
        game = new GameController(name, difficulty, this);
         game.getGUIView().getJLabel().setFont(pixelFont_24);
                game.getGUIView().getJLabel2().setFont(pixelFont_24);
                game.getGUIView().getScore().setFont(pixelFont_24);
                game.getModel().getTimer().getView().setFont(pixelFont_24);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        loadLeaderBoard();
   }

    @Override
    public void windowClosing(WindowEvent e) {
       saveLeaderBoard();
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
          if (Clicksound != null) {
        Clicksound.interrupt();
    }
    //
    Clicksound = new Thread(new Runnable() {
        @Override
        public void run() {
          
                  try {
                    sound = new Sound(getClass().getResource("/sounds/click.wav"));
                       InputStream stream
                        = new ByteArrayInputStream(sound.getSamples());
                sound.play(stream);
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    Clicksound.start();
    }

    public void playBackClickSound() {
           if (BackClickSound != null) {
        BackClickSound.interrupt();
    }
    //
    BackClickSound = new Thread(new Runnable() {
        @Override
        public void run() {
           
                  try {
                    sound = new Sound(getClass().getResource("/sounds/correct.wav"));
                      InputStream stream
                        = new ByteArrayInputStream(sound.getSamples());
                sound.play(stream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
              
           
            
        }
    });

    BackClickSound.start();
    }

    public void playBackgroundMusic() {
        try {
            stopMusic();

            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/music.wav"));
            // Get the audio format and create a new Clip object
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);

            clip.open(audioInputStream);
            //ปรับเสียง
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float gain = 0.2f;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
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
        float gain = 0.2f;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }

    public InsertName getInsertname() {
        return insertname;
    }

    public LeaderBoardController getBoard() {
        return board;
    }

    public int getGamemode() {
        return gamemode;
    }

    public void alert(String text) {
        alert.setVisible(true);
        alert.getScoreLabel().setText(text);
    
        alert.setLocationRelativeTo(this);
        alert.getRestartBtn().addActionListener(this);
        alert.getExtiBtn().addActionListener(this);
        alert.getScoreLabel().setFont(pixelFont_24);
    }

    public void playCardSound() {
        if (CardSound != null) {
        CardSound.interrupt();
    }
    //
    CardSound = new Thread(new Runnable() {
        @Override
        public void run() {
        
                  try {
                    sound = new Sound(getClass().getResource("/sounds/card.wav"));
                     InputStream stream
                        = new ByteArrayInputStream(sound.getSamples());
                sound.play(stream);
                } 
               
           
           catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    CardSound.start();
        
       
    }

    public void playWrongSound() {
        if (WrongSound != null) {
        WrongSound.interrupt();
    }
    //
    WrongSound = new Thread(new Runnable() {
        @Override
        public void run() {
            
            try {
                
                    WrongSound.sleep(200);
                    sound = new Sound(getClass().getResource("/sounds/wrong.wav"));
               
                InputStream stream
                        = new ByteArrayInputStream(sound.getSamples());
               
                sound.play(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    WrongSound.start();
        
    }

    public void playCorrectSound() {
           if (CorrectSound != null) {
        CorrectSound.interrupt();
    }
    //
    CorrectSound = new Thread(new Runnable() {
        @Override
        public void run() {
           
                  try {
                    sound = new Sound(getClass().getResource("/sounds/correct.wav"));
               
                InputStream stream
                        = new ByteArrayInputStream(sound.getSamples());
                sound.play(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    CorrectSound.start();
        
    }

    public void playStartSound() {
         if (StartSound != null) {
        StartSound.interrupt();
    }
    //
    StartSound = new Thread(new Runnable() {
        @Override
        public void run() {
            
                  try {
                        InputStream stream
                        = new ByteArrayInputStream(sound.getSamples());
                sound.play(stream);
                    sound = new Sound(getClass().getResource("/sounds/game-start.wav"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
              
           
        }
    });

    StartSound.start();
    }

    public void playWinMusic() {
        try {
            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/winsong.wav"));
            // Get the audio format and create a new Clip object
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);

            // Open the audio file and start playing it
            clip.open(audioInputStream);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float gain = 1f;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clip.loop(0);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void playGameMusic() {
        try {

            stopMusic();
            Random rand = new Random();
            int randomNum = rand.nextInt(2) + 1;
        
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/GameSong" + randomNum + ".wav"));
            // Load the audio file

            // Get the audio format and create a new Clip object
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);

            clip.open(audioInputStream);
            //ปรับเสียง
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float gain = 0.2f;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        

    }
     public void playLoseMusic() {
        try {
            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/lose-sound.wav"));
            // Get the audio format and create a new Clip object
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);

            // Open the audio file and start playing it
            clip.open(audioInputStream);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float gain = 1f;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clip.loop(0);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }
     public void loadLeaderBoard(){
         
        File f = new File("LeaderBoard.dat");
        if (f.exists()) {
            System.out.println("Board data found");
            try ( FileInputStream fis = new FileInputStream(f);  
                  ObjectInputStream ois = new ObjectInputStream(fis)) {
                ArrayList<Player> savelist = (ArrayList<Player>) ois.readObject();

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
     public void saveLeaderBoard(){
           ArrayList<Player> games = board.getModel().getList();
        try ( FileOutputStream fos = new FileOutputStream("LeaderBoard.dat");  ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(board.getModel().getList());
            System.out.println("save successfull");
        } catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("save unsuccesfull");
        }
     }
}
