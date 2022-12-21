/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel.LeaderBoard;

import java.util.ArrayList;

import java.util.Collections;


import memory_game.game.Player;

/**
 *
 * @author thanakorn
 */
public class LeaderBoardController {

    LeaderBoardView view;
    LeaderBoardModel model;

    public LeaderBoardController() {

        model = new LeaderBoardModel();
        view = new LeaderBoardView();


    }
        public void updateBoard(ArrayList<Player> list) {
        view.getModel().setRowCount(0);
        Collections.sort(list);
        this.model.setList(list);

        for (int i = 0; i < model.getList().size(); i++) {

            view.getModel().addRow(new Object[]{i + 1, model.getList().get(i).getName(),
                model.getList().get(i).getTime(),
                model.getList().get(i).getScore()});

        }

    }


    public LeaderBoardView getView() {
        return view;
    }

    public void setView(LeaderBoardView view) {
        this.view = view;
    }

    public LeaderBoardModel getModel() {
        return model;
    }

    public void setModel(LeaderBoardModel model) {
        this.model = model;
    }


}
