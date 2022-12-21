/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game;

import java.io.Serializable;

/**
 *
 * @author thanakorn
 */
public class Player implements Comparable<Player> , Serializable {
    private String name;
    private int score;
    private String time;

    public Player(String name, int score, String time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }
    

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

     @Override
    public int compareTo(Player other) {
        return other.score - this.score;
    }
}
