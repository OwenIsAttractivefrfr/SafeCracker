package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.net.URL;
import java.applet.*;



public class SafeCracker extends JFrame
{
    JPanel comboPanel = new JPanel();
    JPanel keyPanel = new JPanel();
    JTextField[] comboTextField = new JTextField[4];
    JButton[] keyButtons = new JButton[9];
    JPanel optionsPanel = new JPanel();
    ButtonGroup digitButtonGroup = new ButtonGroup();
    JRadioButton twoDigitRadioButton = new JRadioButton();
    JRadioButton threeDigitRadioButton = new JRadioButton();
    JRadioButton fourDigitRadioButton = new JRadioButton();
    JRadioButton fiveDigitRadioButton = new JRadioButton();
    JPanel buttonsPanel = new JPanel();
    JButton startStopButton = new JButton();
    JButton exitButton = new JButton();
    JPanel resultsPanel = new JPanel();
    JScrollPane resultsPane = new JScrollPane();
    JTextArea resultsTextArea = new JTextArea();
    int numberofDigits;
    String secretCombo;
    Random random = new Random();
    String enteredCombo;
    int didgitsEntered;
    int numberOfRight;
    int positionOfRight;
    AudioClip badSound;
    AudioClip goodSound;

    public SafeCracker()
    {
        setTitle("Safe Cracker");
        ImagePanel banksafe = new ImagePanel(new ImageIcon("./src/com/company/Image/KeyPad.jpg").getImage());
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                exitForm(event);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints;

        banksafe.setPreferredSize(new Dimension(800, 603));
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

        optionsPanel.setPreferredSize(new Dimension(200,100));
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Options:"));
        optionsPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        getContentPane().add(optionsPanel, gridBagConstraints);

        twoDigitRadioButton.setText("Two Digits and Combination");
        twoDigitRadioButton.setSelected(true);
        digitButtonGroup.add(twoDigitRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        optionsPanel.add(twoDigitRadioButton, gridBagConstraints);

        threeDigitRadioButton.setText("Three Digits and Combination");
        digitButtonGroup.add(threeDigitRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        optionsPanel.add(threeDigitRadioButton, gridBagConstraints);

        fourDigitRadioButton.setText("Four Digits and Combination");
        digitButtonGroup.add(fourDigitRadioButton);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        optionsPanel.add(fourDigitRadioButton, gridBagConstraints);


        buttonsPanel.setPreferredSize(new Dimension(200, 700));
        buttonsPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(buttonsPanel, gridBagConstraints);

        startStopButton.setText("Start Game");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        buttonsPanel.add(startStopButton, gridBagConstraints);
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startStopButton(e);

            }
        });
        exitButton.setText("Exit");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0,0,0);
        buttonsPanel.add(exitButton, gridBagConstraints);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });


        resultsPanel.setPreferredSize(new Dimension(200, 250));
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Results: "));
        resultsPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(resultsPanel, gridBagConstraints);

        resultsTextArea.setEditable(false);
        resultsTextArea.setBackground(Color.WHITE);
        resultsPane.setPreferredSize(new Dimension(180, 200));
        resultsPane.setViewportView(resultsTextArea);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        resultsPanel.add(resultsPane, gridBagConstraints);



        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setKeyButtons(false);


        try
        {
            badSound = Applet.newAudioClip(new URL("file:" + "./src/com/company/Sound/badsound.wav"));
            goodSound = Applet.newAudioClip(new URL("file:" + "./src/com/company/Sound/goodsound.wav"));
        }catch(Exception e)
            {
                System.out.println("error loading sound file");
            }
    }


    public void exitForm(WindowEvent event)
    {
        System.exit(0);
    }

    private void keyButtonAction(ActionEvent event)
    {
        String n;
        n = event.getActionCommand();
        keyButtons[Integer.valueOf(n).intValue() - 1].setEnabled(false);
        if(didgitsEntered == 0)
        {
            comboTextField[0].setText("");
            comboTextField[1].setText("");
            comboTextField[2].setText("");
            comboTextField[3].setText("");
        }
        enteredCombo += n;
        didgitsEntered++;
        comboTextField[didgitsEntered - 1].setText(n);
        if(didgitsEntered == numberofDigits)
        {
            for(int i = 0; i < 9; i++)
            {
                keyButtons[i].setEnabled(true);
            }
            resultsTextArea.append("Entered: " + enteredCombo + "\n");
            if(enteredCombo.equals(secretCombo))
            {
                goodSound.play();
                startStopButton.doClick();
            }
            else
            {
                badSound.play();
                numberOfRight = 0;
                for(int i = 0; i < numberofDigits; i++)
                {

                    n = String.valueOf(enteredCombo.charAt(i));
                    for(int j = 0; j < numberofDigits; j++)
                    {
                        if(n.equals(String.valueOf(secretCombo.charAt(j))))
                        {
                            numberOfRight++;
                        }
                    }
                }
                positionOfRight = 0;
                for(int i = 0; i < numberofDigits; i++)
                {
                    if(secretCombo.charAt(i) == enteredCombo.charAt(i))
                    {
                        positionOfRight++;
                    }
                }
                resultsTextArea.append(String.valueOf(numberOfRight) + " Digits correct: " + "\n");
                resultsTextArea.append(String.valueOf(positionOfRight) + " In correct Position " + "\n");
                resultsTextArea.append(String.valueOf("Try Again" + "\n\n"));
                enteredCombo = "";
                didgitsEntered = 0;
            }
        }
    }

    private void startStopButton(ActionEvent event)
    {
        if(startStopButton.getText().equals("Start Game"))
        {
            startStopButton.setText("Stop Game");
            twoDigitRadioButton.setEnabled(false);
            threeDigitRadioButton.setEnabled(false);
            fourDigitRadioButton.setEnabled(false);
            exitButton.setEnabled(true);
            setKeyButtons(true);
            resultsTextArea.setText("");
            if (twoDigitRadioButton.isSelected()) {
                numberofDigits = 2;
            } else if (threeDigitRadioButton.isSelected()) {
                numberofDigits = 3;
            } else {
                numberofDigits = 4;
            }
            for (int i = 0; i < numberofDigits; i++) {
                comboTextField[i].setVisible(true);
                comboTextField[i].setText("");
            }
            if (numberofDigits != 4) {
                for (int i = numberofDigits; i < 4; i++) {
                    comboTextField[i].setVisible(false);
                }
            }
            secretCombo = "";
            int j;
            boolean uniqueDidgit;
            for(int i = 0; i < numberofDigits; i++)
            {
                do
                {
                   j = random.nextInt(9) + 1;
                   uniqueDidgit = true;
                   if(i != 0)
                   {
                       for(int k = 0; k != i; k++)
                       {
                           if(String.valueOf(secretCombo.charAt(k)).equals(String.valueOf(j)))
                           {
                               uniqueDidgit = false;
                           }
                       }
                   }
                } while(!uniqueDidgit);
                secretCombo += String.valueOf(j);
            }
            enteredCombo = "";
            didgitsEntered = 0;
        }
        else
        {
            startStopButton.setText("Start Game");
            twoDigitRadioButton.setEnabled(true);
            threeDigitRadioButton.setEnabled(true);
            fourDigitRadioButton.setEnabled(true);
            exitButton.setEnabled(true);
            setKeyButtons(false);
        }
    }

    private void exitButton(ActionEvent event)
    {
        System.exit(0);
    }

    private void setKeyButtons(boolean a)
    {
        for(int i = 0; i < 9; i++)
        {
            keyButtons[i].setEnabled(a);
        }
    }
}
