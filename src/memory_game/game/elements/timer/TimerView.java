/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.elements.timer;

import javax.swing.JLabel;

/**
 *
 * @author ACER
 */
public class TimerView extends JLabel{
    
    public TimerView() {
        super();
        initialize();
        this.setText("0:0");
    }
    
    private void initialize() {
        // styles
    }
    
    public void setTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        this.setText(minutes + ":" + seconds);
    }
    public JLabel getTimeLabel(){
        return this;
    }
}
