package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SafeCracker extends JFrame
{
    JPanel comboPanel = new JPanel();
    JPanel keyPanel = new JPanel();
    JTextField[] comboTextField = new JTextField[4];
    JButton[] keyButtons = new JButton[9];
    public SafeCracker()
    {
        setTitle("Safe Cracker");
        ImagePanel banksafe = new ImagePanel(new ImageIcon("./src/com/company/Image/Safe3.png").getImage());
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                exitForm(event);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints;

        banksafe.setPreferredSize(new Dimension(330, 420));
        banksafe.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        getContentPane().add(banksafe, gridBagConstraints);


        comboPanel.setPreferredSize(new Dimension(200, 120));
        banksafe.setLayout(new GridBagLayout());
        comboPanel.setBackground(Color.YELLOW);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(120, 0, 0, 0);
        banksafe.add(comboPanel, gridBagConstraints);

        for(int i = 0; i < 4; i++)
        {
            comboTextField[i] = new JTextField();
            comboTextField[i].setPreferredSize(new Dimension(32, 48));
            comboTextField[i].setEditable(false);
            comboTextField[i].setBackground(Color.WHITE);
            comboTextField[i].setText("0");
            comboTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
            comboTextField[i].setFont(new Font("Ariel", Font.BOLD, 18));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = i;
            gridBagConstraints.gridy = 0;
            comboPanel.add(comboTextField[i], gridBagConstraints);
        }

        keyPanel.setPreferredSize(new Dimension(200,120));
        banksafe.setLayout(new GridBagLayout());
        keyPanel.setBackground(Color.BLUE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        banksafe.add(keyPanel, gridBagConstraints);

        for(int i = 0; i < 9; i++)
        {
            keyButtons[i] = new JButton();
            keyButtons[i].setText(String.valueOf(i + 1));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = i%3;
            gridBagConstraints.gridy = i/3;
            keyPanel.add(keyButtons[i], gridBagConstraints);
            keyButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keyButtonAction(e);
                }
            });
        }


        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    }
    public void exitForm(WindowEvent event)
    {
        System.exit(0);
    }

    private void keyButtonAction(ActionEvent event)
    {

    }
}
