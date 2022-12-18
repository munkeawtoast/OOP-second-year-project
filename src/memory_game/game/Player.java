/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game;

/**
 *
 * @author Gungai
 */
public class Player {
    private String name;
    private int score;
    private String mode;
    private String time;
    
    public Player(){
        this.name = "";    
        this.score= 0;
        this.mode = "";
        this.time = "";
    }
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.mode = "";
        this.time = "";
    }
    public Player(String name, int score, String mode){
        this.name = name;
        this.score = score;
        this.mode = mode;
        this.time = "";
    }
      public Player(String name, int score, String mode, String time){
        this.name = name;
        this.score = score;
        this.mode = mode;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
    @Override
    public String toString(){
       return "player name: " + name + "score: " + score + "time: " + time + "mode: "+ mode;
    }
}
