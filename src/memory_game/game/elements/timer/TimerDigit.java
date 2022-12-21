/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.timer;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


/**
 *
 * @author munkeawtoast
 */
public class TimerDigit extends JPanel {
    public static final int NUM = 0;
    public static final int TIME_SEPARATOR = 1;
    private char currentChar;
    private List<TimerPixel> timerPixels;
    
    /**
     * @param type 0 = NUM, 1 = TIME_SEPARATOR
     */
    public TimerDigit(int type) {
        
        super(new GridLayout(5, 4));
         setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        
        timerPixels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TimerPixel newPixel;
            switch (type) {
                case NUM -> {
                    currentChar = '0';
                }
                case TIME_SEPARATOR -> {
                    currentChar = ':';
                }
                default -> throw new AssertionError();

            }
            newPixel = new TimerPixel(getCurrentNumDigits(currentChar)[i]);
            timerPixels.add(newPixel);
            this.add(newPixel);
        }
       
    }
    
    public void initialize() {
        for (TimerPixel timerPixel : timerPixels) {
            timerPixel.initialize();
        }
    }
    
    /**
     * 0-9 = 0-9
     * 10 = :
     *
     */
    private static final boolean[][] PIXELS_POSITION_FOR_DIGIT = {
        {
            true, true, true, false, // 0
            true, false, true, false,
            true, false, true, false,
            true, false, true, false,
            true, true, true, false
        },
        {
            false, false, true, false, // 1
            false, false, true, false,
            false, false, true, false,
            false, false, true, false,
            false, false, true, false
        },
        {
            true, true, true, false,// 2
            false, false, true, false,
            true, true, true, false,
            true, false, false, false,
            true, true, true, false
        },
        {
            true, true, true, false, // 3
            false, false, true, false,
            true, true, true, false,
            false, false, true, false,
            true, true, true, false
        },
        {
            true, false, true, false, // 4
            true, false, true, false,
            true, true, true, false,
            false, false, true, false,
            false, false, true, false
        },
        {
            true, true, true, false,// 5
            true, false, false, false,
            true, true, true, false,
            false, false, true, false,
            true, true, true, false
        },
        {
            true, true, true, false,// 6
            true, false, false, false,
            true, true, true, false,
            true, false, true, false,
            true, true, true, false
        },
        {
            
            true, true, true, false, // 7
            false, false, true, false,
            false, false, true, false,
            false, false, true, false,
            false, false, true, false
        },
        {
            true, true, true, false, // 8
            true, false, true, false,
            true, true, true, false,
            true, false, true, false,
            true, true, true, false
        },
        {
            true, true, true, false, // 9
            true, false, true, false,
            true, true, true, false,
            false, false, true, false,
            true, true, true, false
        },
        {
            false, false, false, false, // :
            false, true, false, false,
            false, false, false, false,
            false, true, false, false,
            false, false, false, false
        },
    };
    
    private boolean[] getCurrentNumDigits(char c) {
        // is 0-9
        if (c == ':') {
            return PIXELS_POSITION_FOR_DIGIT[10];
        } else {
            int num = ((int) c)-48;
            return PIXELS_POSITION_FOR_DIGIT[num];
        }
    }
    
    public void setTo(char c) {
        boolean[] charArray = getCurrentNumDigits(c);
        for (int i = 0; i < 20; i++) {
            timerPixels.get(i).toggle(charArray[i]);
        }
    }
}
