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
            if (i == 2) {
                timerDigits.add(new TimerDigit(TimerDigit.TIME_SEPARATOR));
            } else { 
                timerDigits.add(new TimerDigit(TimerDigit.NUM));
            }
        }
    }
    
    
    // must intialize after adding to frame
    public void initialize() {
        for (TimerDigit timerDigit : timerDigits) {
            timerDigit.initialize();
        }
    }
    
    public String getText() {
        return currentTime;
    }
    
    public void setTime(String formattedTime) {
        currentTime = formattedTIme;
        for (int i = 0; i < 5; i++) {
            char c = formattedTime.charAt(i);
            timerDigits.get(i).setTo(c);
        }
    }
}
