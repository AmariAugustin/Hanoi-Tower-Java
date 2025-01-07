package mainGame;

import javax.swing.*;
import java.awt.*;

//Classe qui permet de creer un rectangle de couleur
public class RectanglePanel extends JPanel {
    private Color color;

    public RectanglePanel(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color); 
        g.fillRect(0, 0, getWidth(), getHeight()); 
    }
}