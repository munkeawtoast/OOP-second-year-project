/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package memory_game.Panel;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Gungai
 */
public class StartMenu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public StartMenu() {
        initComponents();
        returnBtn.setBackground(new Color(0,0,0,0));
        returnBtn.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        easybtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        normalbtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        hardbtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        returnBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
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

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel2.setText("Choose Difficulty");
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
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel6.setLayout(new java.awt.GridLayout(6, 1));

        jPanel7.setBackground(new java.awt.Color(255, 179, 107));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(500, 40));

        easybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/easybtn.png"))); // NOI18N
        easybtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        easybtn.setPreferredSize(new java.awt.Dimension(116, 41));
        easybtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/easybtn-hover.png"))); // NOI18N
        jPanel7.add(easybtn);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 179, 107));
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(500, 40));

        normalbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/normalbtn.png"))); // NOI18N
        normalbtn.setActionCommand("Normal");
        normalbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        normalbtn.setPreferredSize(new java.awt.Dimension(116, 41));
        normalbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/normalbtn-hover.png"))); // NOI18N
        jPanel8.add(normalbtn);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 179, 107));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(500, 40));

        hardbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hardbtn.png"))); // NOI18N
        hardbtn.setActionCommand("Hard");
        hardbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hardbtn.setPreferredSize(new java.awt.Dimension(116, 41));
        hardbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hardbtn-hover.png"))); // NOI18N
        hardbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardbtnActionPerformed(evt);
            }
        });
        jPanel9.add(hardbtn);

        jPanel6.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 179, 107));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(500, 40));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 179, 107));
        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnBtn.setBackground(new java.awt.Color(0, 0, 0));
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        returnBtn.setActionCommand("return2");
        returnBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        returnBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        returnBtn.setSize(new java.awt.Dimension(30, 30));
        returnBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnBtnMousePressed(evt);
            }
        });
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        jPanel11.add(returnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jPanel6.add(jPanel11);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1);
        jPanel1.setBounds(140, 0, 500, 600);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 600));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void hardbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hardbtnActionPerformed

    private void returnBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMouseEntered
        // TODO add your handling code here:
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return2.png")));
    }//GEN-LAST:event_returnBtnMouseEntered

    private void returnBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMouseExited
        // TODO add your handling code here:
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png")));
    }//GEN-LAST:event_returnBtnMouseExited

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnBtnActionPerformed

    private void returnBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMouseClicked
           // TODO add your handling code here:
           
    }//GEN-LAST:event_returnBtnMouseClicked

    private void returnBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMousePressed
        // TODO add your handling code here:
         returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png")));
    }//GEN-LAST:event_returnBtnMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton easybtn;
    private javax.swing.JButton hardbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton normalbtn;
    private javax.swing.JButton returnBtn;
    // End of variables declaration//GEN-END:variables

    public JButton getEasyBtn(){
        return this.easybtn;
    }
    public JButton getNormalBtn(){
        return this.normalbtn;
    }
    public JButton getHardBtn(){
        return this.hardbtn;
    }
    public JButton getReturnBtn(){
        return this.returnBtn;
    }
}


