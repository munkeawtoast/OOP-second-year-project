package memory_game.Panel.customElement;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 30));
        setForeground(new Color(200, 200,200,150 ));
        setBackground(new Color(0, 0, 0,40));
        setOpaque(false);
    }
}
