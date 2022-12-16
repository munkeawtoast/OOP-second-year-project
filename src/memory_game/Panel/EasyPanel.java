/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package memory_game.Panel;

import memory_game.game.elements.card.Tile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import memory_game.game.Player;
import memory_game.game.elements.timer.TimerController;

/**
 *
 * @author Gungai
 */
public class EasyPanel extends javax.swing.JPanel implements ActionListener {
    javax.swing.JPanel[] cardpanels = new javax.swing.JPanel[12];
    Tile[] tiles = new Tile[12];
    ImageIcon[] icons = new ImageIcon[6];
    int status, scoree;
    Tile predict1, predict2;
    private boolean won, helping;
    private TimerController time;
    Alert alert = new Alert();

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }
    

    /**
     * Creates new form EasyPanel
     */
    public EasyPanel() {
        initComponents();
       
        time = new TimerController();

        time.getView().getTimeLabel().setFont(new java.awt.Font("Segoe UI", 0, 36));
        jPanel4.add(time.getView().getTimeLabel());
         ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/logo_new.png")); // load the image to a imageIcon
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(103, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);  // transform it back
        jLabel3.setIcon(icon);
        initIcons();
        initGame();

    }

    private void initGame() {
        scoree = 0;
        int x = 0;
        for (int i = 0; i < tiles.length; i++) {
            ImageIcon icon;
             icon = new ImageIcon(getClass().getResource("/images/backcard.png"));
            Image image = icon.getImage(); 
            Image newimg = image.getScaledInstance(90, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            icon = new ImageIcon(newimg);
            cardpanels[i] = new javax.swing.JPanel();
            cardpanels[i].setOpaque(false);
            cardpanels[i].setBackground(Color.WHITE);
            cardpanels[i].setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
            tiles[i] = new Tile(icons[x], icon);
            tiles[i].addActionListener(this);
           
            
            tiles[i].setPreferredSize(new Dimension(90,120));
            cardpanels[i].add(tiles[i]);
            gamePanel.add(cardpanels[i]);
            if ((i + 1) % 2 == 0) {
                x++;
            }
        }
        score.setText(scoree + "");
        shuffle();

    }

    public int getScoree() {
        return scoree;
    }

    public void setScoree(int scoree) {
        this.scoree = scoree;
    }

    public TimerController getTimeController() {
        return time;
    }

    public void setTimeController(TimerController time) {
        this.time = time;
    }

    private void initIcons() {
        ImageIcon icon;
        for (int i = 0; i < icons.length; i++) {
            icon = new ImageIcon(getClass().getResource("/images/card" + i + ".jpg"));
            Image image = icon.getImage(); 
            Image newimg = image.getScaledInstance(90, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            icon = new ImageIcon(newimg);
            icons[i] = icon;
        }
    }



    private void check() {

        if (predict1 != predict2 && predict1.getImage() == predict2.getImage()) {
                
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        try {
                            predict1.hideTile();
                            predict2.hideTile();
                            Thread.sleep(100);
                            predict1.showTile();
                            predict2.showTile();
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                    predict1.setFinish();
                    predict2.setFinish();
                    for (int i = 0; i < tiles.length; i++) {
                        if (!tiles[i].isFinish()) {
                            won = false;
                            break;
                        } else {
                            won = true;
                        }
                    }
                      if(won){
                       
                        time.stopTime();
                       
                       alert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        alert.setVisible(true);
                     
                        
//                        JOptionPane.showMessageDialog(gamePanel, "You Won! Your Score is " + scoree);
                           
//                        initGame();
                    }
                    System.out.println(won);
                    
                   
                }
            }.start();//animation
            predict1.removeActionListener(this);
            predict2.removeActionListener(this);
            scoree += 100;
            score.setText("" + scoree);
        } else {
            predict1.hideTile();
            predict2.hideTile();
            scoree -= 10;
            score.setText("" + scoree);
        }
       
    }
    
      private void shuffle() {
        gamePanel.removeAll();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 12;) {
            int x = (int) (Math.random() * 12);
            if (!al.contains(x)) {
                al.add(x);
                i++;
            }
        }
        for (int i = 0; i < 12; i++) {
            gamePanel.add(cardpanels[al.get(i)]);
            tiles[al.get(i)].hideTile();
        }
    }
          @Override
    public void actionPerformed(ActionEvent e) {
        if (status == 0) {
            predict1 = (Tile) e.getSource();
            predict1.showTile();
            status++;
        } else if (status == 1) {
            status++;
            predict2 = (Tile) e.getSource();
            new Thread() {
                @Override
                public void run() {
                    try {
                        predict2.showTile();
                        Thread.sleep(500);
                        check();
                        Thread.sleep(600);
                        status = 0;
                       
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }.start();

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 153));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 75));
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 75));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        jLabel2.setText("Score:");
        jPanel2.add(jLabel2);

        score.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        score.setText("0");
        jPanel2.add(score);

        jPanel3.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(204, 255, 153));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 75));

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        jLabel1.setText("Time: ");
        jPanel4.add(jLabel1);

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel1.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.add(jLabel3);

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        gamePanel.setOpaque(false);
        gamePanel.setLayout(new java.awt.GridLayout(3, 4, 50, 0));
        add(gamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 800, 525));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel score;
    // End of variables declaration//GEN-END:variables

}
