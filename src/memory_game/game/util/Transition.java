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
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final int OPACITY = 4;
    
    public static final int LINEAR = 0;
    public static final int SHAKE = 1;
    public static final int EASE_IN_SINE = 2;
    public static final int EASE_IN_OUT_CUBIC = 3;

    public static double linear(double x) {
        return x;
    }
    
    public static double shake(double x) {
        return Math.sin(3 * x * Math.PI + Math.PI / 2) * (1 - x);
    }
    
    public static double easeInSine(double x) {
        return 1 - Math.cos((x * Math.PI) / 2);
    }
    
    /**
     *
     * @param x percentage of animation”
     * @return
     */
    public static double easeInOutCubic(double x) {
        return x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2;
    }
    
    // TODO: เพิ่ม transition types
}
