/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game.util;

/**
 *
 * @author munkeawtoast
 */
public class Transition {
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
        
    public static final int EASE_IN_OUT_CUBIC = 0;
    
    // เอามาจาก https://easings.net/#easeInOutCubic จ้า
    
    /**
     *
     * @param x percentage of animation”
     * @return
     */
    public static double easeInOutCubic(double x) {
        return x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2;
    }
}
