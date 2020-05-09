import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class PaintedPanel extends JPanel
{
    Color color = new Color(0,0,255);
    int radius = 90;
    int framex = 300;
    int framey = 300;
    int rectx = 50;
    int recty = 50;
    @Override
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int width = this.getWidth();
    int height = this.getHeight();
    Graphics2D g2d = (Graphics2D)g;
    // make a brand new Graphic so you can freely rotate it
    g2d.setColor(color);
    // need to change center of rectangle
    Rectangle rect = new Rectangle(width/2 - rectx/2, height/2 - recty/2, rectx, recty);
    g2d.rotate(Math.toRadians(radius), (width/2), (height/2));
    g2d.draw(rect);
    g2d.fill(rect);
    }

}
