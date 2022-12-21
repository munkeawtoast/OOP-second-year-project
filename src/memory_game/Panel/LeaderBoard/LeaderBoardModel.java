/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel.LeaderBoard;

import java.util.ArrayList;

import memory_game.game.Player;

/**
 *
 * @author thanakorn
 */
public class LeaderBoardModel {
    ArrayList<Player> list;
    public LeaderBoardModel(){
        list = new ArrayList<>();
    }

    public ArrayList<Player> getList() {
        return list;
    }

    public void setList(ArrayList<Player> list) {
        this.list = list;
    }
    public void addToList(Player player){
        this.list.add(player);
    }
}
