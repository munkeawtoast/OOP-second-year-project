/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package memory_game.Panel.LeaderBoard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import memory_game.Panel.customElement.ScrollBarCustom;

/**
 *
 * @author thanakorn
 */
public class LeaderBoardView extends javax.swing.JPanel {

    private DefaultTableModel model;
    private static final Image backgroundImage = new ImageIcon(LeaderBoardView.class.getResource("/images/back.jpg")).getImage();

    /**
     * Creates new form LeaderBoard
     */
    public LeaderBoardView() {
        initComponents();

        model = new DefaultTableModel();
        model.addColumn("#");
        model.addColumn("Name");
        model.addColumn("Time");
        model.addColumn("Score");
        scrollpane.getViewport().setOpaque(false);

        table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0));
        table.setEnabled(false);
        scrollpane.setBorder(new EmptyBorder(0, 0, 0, 0));
        table.setRowHeight(40);
        table.getTableHeader().setSize(100, 80);
        table.getTableHeader().setBackground(new Color(0,0,0,0));
        table.getTableHeader().setBorder(null);
        table.getTableHeader().setEnabled(false);
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 36));
        scrollpane.setVerticalScrollBar(new ScrollBarCustom());
        table.setEnabled(false);

// Get the default renderer for the cells in the table
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getDefaultRenderer(Object.class);

// Set the horizontal alignment to be centered
        renderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();

// Set the horizontal alignment to be centered
renderer2.setHorizontalAlignment(JLabel.CENTER);

// Set the renderer to be used for all header cells
table.getTableHeader().setDefaultRenderer(renderer2);
table.setForeground(new Color(255,192,95));

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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        returnBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 150));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel4.setText("LeaderBoard LOGO");
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 100));
        jLabel4.setSize(new java.awt.Dimension(200, 100));
        jPanel1.add(jLabel4);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 525));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 70));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnBtn.setBackground(new java.awt.Color(0, 0, 0));
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        returnBtn.setActionCommand("return1");
        returnBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        returnBtn.setPreferredSize(new java.awt.Dimension(70, 40));
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
        jPanel5.add(returnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 70));

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(50, 0));
        jPanel2.add(jPanel4, java.awt.BorderLayout.LINE_START);

        scrollpane.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setOpaque(false);
        scrollpane.setViewportView(table);

        jPanel2.add(scrollpane, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_returnBtnMouseClicked

    private void returnBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMouseEntered
        // TODO add your handling code here:
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return2.png")));
    }//GEN-LAST:event_returnBtnMouseEntered

    private void returnBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMouseExited
        // TODO add your handling code here:
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png")));
    }//GEN-LAST:event_returnBtnMouseExited

    private void returnBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBtnMousePressed
        // TODO add your handling code here:
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png")));
    }//GEN-LAST:event_returnBtnMousePressed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton returnBtn;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    public JTable getTable() {
            return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        // thank you ChatGPT
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

    public JButton getReturnBtn() {
        return returnBtn;
    }
}
