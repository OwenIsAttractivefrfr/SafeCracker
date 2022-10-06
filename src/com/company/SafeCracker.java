package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SafeCracker extends JFrame
{
    ImagePanel banksafe;
    public SafeCracker()
    {
        setTitle("Safe Cracker");
        ImagePanel banksafe = new ImagePanel(new ImageIcon("./src/com/company/Image/Safe3.png").getImage());
        setVisible(true);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                exitForm(event);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints;

        banksafe.setPreferredSize(new Dimension(245, 205));
        banksafe.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        getContentPane().add(banksafe, gridBagConstraints);

        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    }
    public void exitForm(WindowEvent event)
    {
        System.exit(0);
    }
}
