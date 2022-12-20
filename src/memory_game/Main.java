package memory_game;

import memory_game.Panel.Alert;


public class Main {
    public static void main(String[] args) {
        try{
//            new Frame();
            new GameFrame();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
