package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ImagePanel extends JPanel
{
    private Image image;

    public ImagePanel(Image image)
    {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        g.drawImage(image, 0, 0, null);
    }
}
