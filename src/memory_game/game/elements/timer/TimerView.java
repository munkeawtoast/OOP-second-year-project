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
        this.setText("00:00");
    }
    
    private void initialize() {
        // styles
    }
    
    public void setTime(String formattedTime) {
        setText(formattedTime);
    }
    public JLabel getTimeLabel(){
        return this;
    }
}
