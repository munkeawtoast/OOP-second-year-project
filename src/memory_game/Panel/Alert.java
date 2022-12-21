/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package memory_game.Panel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import memory_game.game.GameGUIView;



/**
 *
 * @author Gungai
 */
public class Alert extends JFrame {

    /**
     * Creates new form alert
     */
    public Alert() {
        setUndecorated(true); 
        initComponents();
      ;
       
     
        
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
// <-- the title bar is removed here
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
        jPanel1 = new javax.swing.JPanel();
        score = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        restartBtn = new javax.swing.JButton();
        extiBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 150));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 45));

        score.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        score.setText("jLabel1");
        jPanel1.add(score);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 75));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        restartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restartbtn.png"))); // NOI18N
        restartBtn.setActionCommand("Restart");
        restartBtn.setBorderPainted(false);
        restartBtn.setContentAreaFilled(false);
        restartBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restartBtn.setFocusPainted(false);
        restartBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restartbtn-hover.png"))); // NOI18N
        restartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartBtnActionPerformed(evt);
            }
        });
        jPanel2.add(restartBtn);

        extiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exittomainbtn.png"))); // NOI18N
        extiBtn.setActionCommand("Tomenu");
        extiBtn.setBorderPainted(false);
        extiBtn.setContentAreaFilled(false);
        extiBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        extiBtn.setFocusable(false);
        extiBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exittomainbtn-hover.png"))); // NOI18N
        jPanel2.add(extiBtn);

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 400, 75));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alertbox.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restartBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton extiBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton restartBtn;
    private javax.swing.JLabel score;
    // End of variables declaration//GEN-END:variables

    public JLabel getScoreLabel() {
        return score;
    }

    public void setScoreLabel(JLabel score) {
        this.score = score;
    }

    public JButton getExtiBtn() {
        return extiBtn;
    }

    public void setExtiBtn(JButton extiBtn) {
        this.extiBtn = extiBtn;
    }

    public JButton getRestartBtn() {
        return restartBtn;
    }

    public void setRestartBtn(JButton restartBtn) {
        this.restartBtn = restartBtn;
    }

    
}
