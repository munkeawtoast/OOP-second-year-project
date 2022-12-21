/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package memory_game.Panel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Gungai
 */
public class Menu extends JPanel {
private static final Image backgroundImage = new ImageIcon(Menu.class.getResource("/images/bg_gif.gif")).getImage();

  
    public Menu() {
        initComponents();
        
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        double panelAspectRatio = (double) getWidth() / (double) getHeight();
        double imageAspectRatio = (double) backgroundImage.getWidth(null) / (double) backgroundImage.getHeight(null);

        int imageWidth;
        int imageHeight;
        if (panelAspectRatio > imageAspectRatio) {
            imageWidth = getWidth();
            imageHeight = (int) (imageWidth / imageAspectRatio);
        } else {
            imageHeight = getHeight();
            imageWidth = (int) (imageHeight * imageAspectRatio);
        }

        g.drawImage(backgroundImage, (getWidth() - imageWidth) / 2, (getHeight() - imageHeight) / 2, imageWidth, imageHeight, this);
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        startbtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        leaderbtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        exitbtn = new javax.swing.JButton();
        mutebtn = new javax.swing.JButton();
        unmutebtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 61, 61));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 179, 107));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 200));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 179, 107));
        jPanel3.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_new.png"))); // NOI18N
        jPanel3.add(jLabel2);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 179, 107));
        jPanel5.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 179, 107));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(5, 1));

        jPanel7.setBackground(new java.awt.Color(255, 179, 107));
        jPanel7.setOpaque(false);

        startbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbutton.png"))); // NOI18N
        startbtn.setActionCommand("Start");
        startbtn.setBorderPainted(false);
        startbtn.setContentAreaFilled(false);
        startbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startbtn.setFocusable(false);
        startbtn.setPreferredSize(new java.awt.Dimension(163, 60));
        startbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbutton-hover.png"))); // NOI18N
        startbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startbtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startbtnMousePressed(evt);
            }
        });
        jPanel7.add(startbtn);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 179, 107));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        leaderbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ldbbutton.png"))); // NOI18N
        leaderbtn.setActionCommand("Leaderboard");
        leaderbtn.setBorderPainted(false);
        leaderbtn.setContentAreaFilled(false);
        leaderbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leaderbtn.setPreferredSize(new java.awt.Dimension(163, 41));
        leaderbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ldbbutton-hover.png"))); // NOI18N
        jPanel8.add(leaderbtn);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 179, 107));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitbutton.png"))); // NOI18N
        exitbtn.setActionCommand("Exit");
        exitbtn.setBorder(null);
        exitbtn.setBorderPainted(false);
        exitbtn.setContentAreaFilled(false);
        exitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitbutton-hover.png"))); // NOI18N
        jPanel9.add(exitbtn);

        jPanel6.add(jPanel9);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1);
        jPanel1.setBounds(140, 0, 500, 600);

        mutebtn.setForeground(new java.awt.Color(242, 242, 242));
        mutebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sound_on.png"))); // NOI18N
        mutebtn.setActionCommand("unmute");
        mutebtn.setBorder(null);
        mutebtn.setBorderPainted(false);
        mutebtn.setContentAreaFilled(false);
        mutebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mutebtn.setFocusable(false);
        mutebtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        mutebtn.setSize(new java.awt.Dimension(30, 30));
        mutebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutebtnActionPerformed(evt);
            }
        });
        add(mutebtn);
        mutebtn.setBounds(90, 500, 30, 30);

        unmutebtn.setForeground(new java.awt.Color(242, 242, 242));
        unmutebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sound_mute.png"))); // NOI18N
        unmutebtn.setActionCommand("mute");
        unmutebtn.setBorder(null);
        unmutebtn.setBorderPainted(false);
        unmutebtn.setContentAreaFilled(false);
        unmutebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unmutebtn.setFocusable(false);
        unmutebtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        unmutebtn.setSize(new java.awt.Dimension(30, 30));
        unmutebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unmutebtnActionPerformed(evt);
            }
        });
        add(unmutebtn);
        unmutebtn.setBounds(40, 500, 30, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void startbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startbtnMouseEntered
        // TODO add your handling code here:
         startbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbutton-hover.png")));
         
    }//GEN-LAST:event_startbtnMouseEntered

    private void startbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startbtnMouseExited
        // TODO add your handling code here:
         startbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbutton.png")));
    }//GEN-LAST:event_startbtnMouseExited

    private void startbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startbtnMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_startbtnMouseClicked

    private void startbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startbtnMousePressed
        // TODO add your handling code here:
         startbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbutton.png")));
    }//GEN-LAST:event_startbtnMousePressed

    private void mutebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mutebtnActionPerformed

    private void unmutebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unmutebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unmutebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton leaderbtn;
    private javax.swing.JButton mutebtn;
    private javax.swing.JButton startbtn;
    private javax.swing.JButton unmutebtn;
    // End of variables declaration//GEN-END:variables

    public JButton getStartBtn(){
        return this.startbtn;
    }
    public JButton getLeaderBtn(){
        return this.leaderbtn;
    }
    public JButton getExitBtn(){
        return this.exitbtn;
    }
    public JButton getMutebtn(){
        return this.mutebtn;
    }

    public JButton getUnmutebtn() {
        return unmutebtn;
    }
    
}


