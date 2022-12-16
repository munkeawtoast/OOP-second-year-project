
import java.util.List;
import memory_game.game.Player;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author thanakorn
 *
 */
import java.util.*;

public class testSort {

    public testSort() {
        Player p1 = new Player("Game1", 10, "easy");
        Player p2 = new Player("Game2", 15, "easy");
        Player p3 = new Player("Game3", 20, "easy");
        Player p4 = new Player("Game4", 25, "easy");
        Player p5 = new Player("Game5", 30, "easy");
        ArrayList<Player> players = new ArrayList<>();

// list of Player objects to be sorted
        players.add(p5);
        players.add(p4);
        players.add(p2);
        players.add(p3);
        players.add(p1);
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p1.getScore() - p2.getScore();
            }
        });
       for(Player player : players){
           System.out.println(player.getScore());
       }
//Collections.sort(players, new Comparator<Player>() {
//            @Override
//            public int compare(Player p1, Player p2) {
//                return p2.getScore() - p1.getScore();
//            }
//        });
    }

    public static void main(String[] args) {
        new testSort();
    }
}
