package memory_game.Panel.customElement;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 20));
        setForeground(new Color(0, 160,0 ));
        setBackground(new Color(0, 0, 0,0));
        setOpaque(false);
    }
}
