/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel.LeaderBoard;

import java.util.ArrayList;
import javax.swing.JFrame;
import memory_game.game.Game;

/**
 *
 * @author thanakorn
 */
public class LeaderboardTest extends JFrame{
    public LeaderboardTest(){
        
    
    ArrayList<Game> players = new ArrayList<>();
    for(int i =0;i<30;i++){
   players.add(new Game("game", 2));
   players.get(i).setScore(i+10);
    }
    LeaderBoardController leaderboard = new LeaderBoardController();
    leaderboard.updateBoard(players);
        
        setContentPane(leaderboard.getView());
    pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        try {
            new LeaderboardTest();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
