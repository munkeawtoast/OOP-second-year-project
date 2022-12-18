/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel.LeaderBoard;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    LeaderBoardModel model;
    public LeaderBoardController(){
       
        model = new LeaderBoardModel();
        view = new LeaderBoardView();
    
      
           
       
        
      view.getTable().setModel(view.getModel());
   
     
   

    }

   

    public LeaderBoardView getView() {
        return view;
    }

    public void setView(LeaderBoardView view) {
        this.view = view;
    }
    public void updateBoard(ArrayList<Game> list){
        Collections.sort(list);
        this.model.setList(list);
        
         
        for(int i = 0; i<model.getList().size();i++){
           view.getModel().addRow(new Object[]{i+1,model.getList().get(i).getPlayerName(),model.getList().get(i).getTimer().getView().getText(),model.getList().get(i).getScore()});
           i++;
         }
        
    }

    
    
   
}
