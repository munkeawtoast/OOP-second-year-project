/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import memory_game.game.Player;

/**
 *
 * @author thanakorn
 */
public class LeaderBoardController {
    LeaderBoardView view;
    ArrayList<Player> players;
    public LeaderBoardController(){
        Player p1 = new Player("Game",20,"easy","02:30");
        players = new ArrayList();
        view = new LeaderBoardView();
        players.add(p1);
        int i = 1;
         for(Player player : players){
           
           view.getModel().addRow(new Object[]{i,player.getName(),player.getTime(),player.getScore()});
           
       }
    
    
    
    
    view.getTable().setModel(view.getModel());
    view.getTable().setPreferredSize(new Dimension(800,500));
    view.setScrollpane(new JScrollPane(view.getTable()));
    view.getjPanel2().add(view.getScrollpane());
    }

    public LeaderBoardView getView() {
        return view;
    }

    public void setView(LeaderBoardView view) {
        this.view = view;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
     public static void main(String[] args) {
         JFrame frame = new JFrame();
  LeaderBoardController panel = new LeaderBoardController();
  frame.add(panel.getView());
  frame.pack();
  frame.setVisible(true);
  frame.setSize(800,600);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
