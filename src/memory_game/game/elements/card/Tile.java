package memory_game.game.elements.card;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Rajesh Kumar Sahanee
 */
public class Tile extends JButton {

    ImageIcon icon1;
    ImageIcon icon2;
    private boolean hidden, Finish;

    public Tile(ImageIcon icon1, ImageIcon icon2) {
        this.icon1 = icon1;
        this.icon2 = icon2;
        setSize(120,150);
        setFocusable(false);
    }

    public synchronized void showTile() {
        setIcon(icon1);
        hidden = false;
    }

    public synchronized void hideTile() {
        setIcon(icon2);
        hidden = true;
    }

    public synchronized void setFinish() {
        showTile();
        Finish = true;
    }

    public ImageIcon getImage() {
        return icon1;
    }

    public synchronized boolean isFinish() {
        return Finish;
    }

}
