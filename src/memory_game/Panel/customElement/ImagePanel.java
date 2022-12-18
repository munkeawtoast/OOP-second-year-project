/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory_game.Panel.customElement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author thanakorn
 */
public class ImagePanel extends JPanel {
  private BufferedImage image;

  public ImagePanel(String path) {
    try {
      image = ImageIO.read(new File(path));
    } catch (IOException ex) {
      // handle exception
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return image == null ? new Dimension(100, 100) : new Dimension(image.getWidth(), image.getHeight());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, this);
  }
}