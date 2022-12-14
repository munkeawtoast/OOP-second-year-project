/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.mainmenu;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author Gungai
 * 
 */
public class GridPanel extends JPanel {
   int numButtons;
   static String pics[] = {"images/card1.jpg", "images/card2.jpg", 
       "images/card1.jpg", "images/card2.jpg", "images/card1.jpg", 
       "images/card2.jpg"};
   static JButton[] buttons;
   ImageIcon cardBack = new ImageIcon(this.getClass().getResource("/images/backcard.png"));
   ImageIcon[] icons;
   private ImageIcon temp;
   private boolean gameOver;
   int openImages;
   public int currentIndex;
   public int oddClickIndex;
   public int numClicks;
   public GridPanel(){
       setBorder(new EmptyBorder(0, 0, 0, 0));
       setLayout(new GridLayout(0,4,0,0));
       setVisible(true);
       setBackground(Color.WHITE);
       addButtons();
       
   }
   private void addButtons(){
       numButtons = pics.length *2 ;
       buttons = new JButton[numButtons];
       icons = new ImageIcon[numButtons];
       for(int i =0, j = 0; i < pics.length; i++){
           icons[j] = new ImageIcon(this.getClass().getResource(pics[i]));
           buttons[j] = new JButton("");
           buttons[j].addActionListener(new GridPanel.ImageButtonListener());
           buttons[j].setIcon(cardBack);
           buttons[j].setBackground(Color.WHITE);
           this.add(buttons[j++]); 
           
           icons[j] = icons[j-1];
           buttons[j] = new JButton("");
           buttons[j].addActionListener(new GridPanel.ImageButtonListener());
           buttons[j].setIcon(cardBack);
           buttons[j].setBackground(Color.WHITE);
           this.add(buttons[j++]); 
       }
       Random rnd = new Random();
       for (int i = 0; i < numButtons; i++){
           int j = rnd.nextInt(numButtons);
           temp = icons[i];
           icons[i] = icons[j];
           icons[j] = temp;
       }
       
   }
   private class ImageButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            openImages++;
            System.out.println(openImages);
            
            for(int i = 0; i< numButtons; i++){
                if(e.getSource() == buttons[i]){
                    buttons[i].setIcon(icons[i]);
                    currentIndex = i;
                }
            }
            if(openImages % 2 == 0){
                if(currentIndex == oddClickIndex){
                    numClicks--;
                    return;
                }
                if(icons[currentIndex] != icons[oddClickIndex]){
                    
                }
            }
        }
       
   }
   
 
}

