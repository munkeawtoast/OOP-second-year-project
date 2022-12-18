/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel.LeaderBoard;

import java.util.ArrayList;
import memory_game.game.Game;

/**
 *
 * @author thanakorn
 */
public class LeaderBoardModel {
    ArrayList<Game> list;
    public LeaderBoardModel(){
        list = new ArrayList<Game>();
    }

    public ArrayList<Game> getList() {
        return list;
    }

    public void setList(ArrayList<Game> list) {
        this.list = list;
    }
    
}
