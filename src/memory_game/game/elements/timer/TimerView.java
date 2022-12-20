/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.timer;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class TimerView extends JPanel{
    List<TimerDigit> timerDigits; 
    String currentTime = "00:00";
    public TimerView() {
        super(new GridLayout(1, 5));
        timerDigits = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TimerDigit timerDigit;
            if (i == 2) {
                timerDigit = new TimerDigit(TimerDigit.TIME_SEPARATOR);
            } else { 
                timerDigit = new TimerDigit(TimerDigit.NUM);
            }
            timerDigits.add(timerDigit);
            this.add(timerDigit);
        }
        
    }
    
    
    public String getText() {
        return currentTime;
    }
    
    public void setTime(String formattedTime) {
        currentTime = formattedTime;
        for (int i = 0; i < 5; i++) {
            char c = formattedTime.charAt(i);
            timerDigits.get(i).setTo(c);
        }
    }
}
