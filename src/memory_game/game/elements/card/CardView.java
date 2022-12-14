
package memory_game.game.elements.card;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CardView extends JPanel {
    private JButton card;
    public CardView(Dimension dimension, ImageIcon image) {
        super(new FlowLayout());
        this.setSize(dimension);
        
        card = new JButton(image);
    }
    
    public CardView(Dimension dimension) {
        this(dimension, null);
    }
    
    public void setCardImage(ImageIcon image) {
        card.setIcon(image);
    }
    
    public void setCardSize(Dimension dimension) {
        card.setSize(dimension);
    }
    
    public Dimension getCardSize() {
        return card.getSize();
    }
    
    public JButton getCard() {
        return card;
    }
}
