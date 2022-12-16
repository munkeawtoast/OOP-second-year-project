/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.game;


import java.util.logging.Logger;
import java.util.logging.Level;
import memory_game.game.elements.card.CardController;
/**
 *
 * @author munkeawtoast
 */
public class GameLoggerView implements IGameView {
    private GameController gameController;
    private Game game;
    private Logger logger;
    public GameLoggerView(GameController gameController) {
        this.gameController = gameController;
        this.game = gameController.getModel();
        this.logger = Logger.getLogger(game.getClass().getName());
    }
    
    @Override
    public void initialize() {
        logger.log(Level.INFO, "Game view started succesfully");
    }

    @Override
    public void handleClickWhenAnim() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleCorrect(CardController card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleWrong(CardController card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleGameStart() {
        logger.log(Level.INFO, "Game starting, playerName: {0}", game.getPlayerName());
    }

    @Override
    public void handleGameEnd() {
        logger.log(Level.INFO, "Game ending, playerName: {0}, score:{1}", new Object[]{game.getPlayerName(), game.getScore()});
    }
    
}
