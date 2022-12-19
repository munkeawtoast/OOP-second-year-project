
package memory_game.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import memory_game.game.elements.card.CardController;
import memory_game.game.elements.card.CardView;
import memory_game.game.elements.timer.TimerView;


public class GameGUIView extends JPanel implements IGameView {
    private static final Image IMAGE_EASY = new ImageIcon(GameGUIView.class.getResource("/images/back.jpg")).getImage();
    private static final Image IMAGE_MEDIUM = new ImageIcon(GameGUIView.class.getResource("/images/back_medium.jpg")).getImage();
    private static final Image IMAGE_HARD = new ImageIcon(GameGUIView.class.getResource("/images/back_hard.jpg")).getImage();
    private static final int CARD_GAP = 30;
    
    private GameController gameController;
    private Game game;
    private JPanel cardGrid;
    private TimerView timer;
    private JLabel scoreLabel;
    private Image backgroundImage;
     private javax.swing.JPanel Headpanel;
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JPanel Scorepanel;
    private javax.swing.JPanel Timepanel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel score;
    
    public GameGUIView(GameController gameController) {
        
        setPreferredSize(new Dimension(800,600));
        setLayout(new BorderLayout());
        this.gameController = gameController;
        this.game = gameController.getModel();
        this.timer = game.getTimerController().getView();
        switch(game.getDifficulty()) {
            case Game.TEST -> {
                this.backgroundImage = IMAGE_EASY;
            }
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
        gamePanel = new JPanel();
        gamePanel.setOpaque(false);
         Headpanel = new javax.swing.JPanel();
        Scorepanel = new javax.swing.JPanel();
        JLabel = new javax.swing.JLabel();
         JLabel2 = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        Timepanel = new javax.swing.JPanel();
        jPanel1 = new JPanel();
        Headpanel.setOpaque(false);
        Headpanel.setPreferredSize(new java.awt.Dimension(800, 35));
        Headpanel.setRequestFocusEnabled(false);
        Headpanel.setLayout(new java.awt.BorderLayout());

        Scorepanel.setBackground(new java.awt.Color(204, 255, 153));
        Scorepanel.setOpaque(false);
        Scorepanel.setPreferredSize(new java.awt.Dimension(300, 35));
        Scorepanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));
        
        JLabel.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        JLabel.setText("Score:");
        Scorepanel.add(JLabel);

        score.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        score.setText("0");
        Scorepanel.add(score);
        
        Headpanel.add(Scorepanel, java.awt.BorderLayout.LINE_START);

     
        Timepanel.setOpaque(false);
        Timepanel.setPreferredSize(new java.awt.Dimension(300, 35));

        
        JLabel2.setText("Time: ");
        Timepanel.add(JLabel2);

        Headpanel.add(Timepanel, java.awt.BorderLayout.EAST);
         Headpanel.add(jPanel1, java.awt.BorderLayout.CENTER);
         jPanel1.setOpaque(false);
         
         add(Headpanel,BorderLayout.NORTH);
//         add(gamePanel,BorderLayout.CENTER);
       

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
        
        Dimension grid = new Dimension();
        
        cardGrid = new JPanel();
        switch (game.getDifficulty()) {
            case Game.TEST -> {
                grid = new Dimension(2, 1);
            }
            case Game.EASY -> {
                grid = new Dimension(4, 3);
            }
            case Game.MEDIUM -> {
                grid = new Dimension(5, 4);
            }
            case Game.HARD -> {
                grid = new Dimension(6, 4);
            }
        }
        
        cardGrid.setLayout(new GridLayout(grid.height, grid.width, CARD_GAP, CARD_GAP));
        
        for (CardController cardController : game.getCardList()) {
            cardGrid.add(cardController.getView());
        }
        
        cardGrid.setOpaque(false);
//        gamePanel.add(cardGrid,BorderLayout.CENTER);
add(cardGrid,BorderLayout.CENTER);
        
        // padding
        Dimension newSize = cardGrid.getPreferredSize();
        newSize.height += 60;
        newSize.width += 90;
        cardGrid.setPreferredSize(newSize);
        cardGrid.setBackground(new Color(0,0,0,0));
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

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getJLabel() {
        return JLabel;
    }

    public JLabel getJLabel2() {
        return JLabel2;
    }

    public JLabel getScore() {
        return score;
    }

    public JPanel getTimepanel() {
        return Timepanel;
    }
    
    
    
}
