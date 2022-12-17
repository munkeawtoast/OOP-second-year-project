/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import memory_game.game.Game;
import memory_game.game.Player;

/**
 *
 * @author thanakorn
 */
public class LeaderBoardController {
    LeaderBoardView view;
    ArrayList<Game> players;
    public LeaderBoardController(){
        Game g1 = new Game("Game", 2);
        players = new ArrayList<Game>();
        view = new LeaderBoardView();
        players.add(g1);
        int i = 1;
        for(int j =0;j<90; j++){
         for(Game player : players){
           
           view.getModel().addRow(new Object[]{j,player.getPlayerName(),player.getTimer().getView().getText(),player.getScore()});
           
       }
        }
      view.getTable().setModel(view.getModel());
      
    
    
    
//    
    view.getTable().setModel(view.getModel());
   

    }

    public LeaderBoardView getView() {
        return view;
    }

    public void setView(LeaderBoardView view) {
        this.view = view;
    }

    public ArrayList<Game> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Game> players) {
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
