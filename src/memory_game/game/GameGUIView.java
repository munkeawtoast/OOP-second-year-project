
package memory_game.game;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.timer.TimerView;


public class GameGUIView extends JPanel implements IGameView {
    private static final Image IMAGE_EASY = new ImageIcon(GameGUIView.class.getResource("/images/back.jpg")).getImage();
    private static final Image IMAGE_MEDIUM = new ImageIcon(GameGUIView.class.getResource("/images/back_medium.jpg")).getImage();
    private static final Image IMAGE_HARD = new ImageIcon(GameGUIView.class.getResource("/images/back_hard.jpg")).getImage();
    
    private GameController gameController;
    private Game game;
    private JPanel cardGrid;
    private TimerView timer;
    private JLabel scoreLabel;
    private Image backgroundImage;

    public GameGUIView(GameController gameController) {
        this.gameController = gameController;
        this.game = gameController.getModel();
        this.timer = game.getTimerController().getView();
        switch(game.getDifficulty()) {
            case Game.EASY -> {
                this.backgroundImage = IMAGE_EASY;
            }
            case Game.MEDIUM -> {
                this.backgroundImage = IMAGE_MEDIUM;
            }
            case Game.HARD -> {
                this.backgroundImage = IMAGE_HARD;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        // thank you ChatGPT
        double panelAspectRatio = (double) getWidth() / (double) getHeight();
        double imageAspectRatio = (double) backgroundImage.getWidth(null) / (double) backgroundImage.getHeight(null);

        int imageWidth;
        int imageHeight;
        if (panelAspectRatio > imageAspectRatio) {
            imageWidth = getWidth();
            imageHeight = (int) (imageWidth / imageAspectRatio);
        } else {
            imageHeight = getHeight();
            imageWidth = (int) (imageHeight * imageAspectRatio);
        }

        g.drawImage(backgroundImage, (getWidth() - imageWidth) / 2, (getHeight() - imageHeight) / 2, imageWidth, imageHeight, this);
    }
    
    
    
    @Override
    public void initialize() {
        // padding
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        
        cardGrid = new JPanel();
        switch (game.getDifficulty()) {
            case Game.EASY -> {
                cardGrid.setLayout(new GridLayout(3, 4, 30, 30));
            }
            case Game.MEDIUM -> {
                cardGrid.setLayout(new GridLayout(4, 5, 30, 30));
            }
            case Game.HARD -> {
                cardGrid.setLayout(new GridLayout(5, 6, 30, 30));
            }
        }
        
        for (CardController cardController : game.getCardList()) {
            cardGrid.add(cardController.getView());
        }
        
        
        cardGrid.setOpaque(false);
        this.add(cardGrid);
    }
    
    @Override
    public void handleClickWhenAnim() {
        
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
    public void handleGameStart() {}

    @Override
    public void handleGameEnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
