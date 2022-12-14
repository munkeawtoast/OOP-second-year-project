/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package memory_game.mainmenu;

import javax.swing.JButton;

/**
 *
 * @author Gungai
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
        
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
        startbtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        leaderbtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        exitbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 102));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 61, 61));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 179, 107));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 200));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 179, 107));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1.png"))); // NOI18N
        jPanel3.add(jLabel2);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 179, 107));

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
        jPanel6.setLayout(new java.awt.GridLayout(7, 1));

        jPanel7.setBackground(new java.awt.Color(255, 179, 107));

        startbtn.setText("Start");
        startbtn.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel7.add(startbtn);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 179, 107));

        leaderbtn.setText("Leaderboard");
        leaderbtn.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel8.add(leaderbtn);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 179, 107));

        exitbtn.setText("Exit");
        exitbtn.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel9.add(exitbtn);

        jPanel6.add(jPanel9);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1);
        jPanel1.setBounds(140, 0, 500, 600);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JButton startbtn;
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
}


