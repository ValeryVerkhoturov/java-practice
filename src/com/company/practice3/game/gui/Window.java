package com.company.practice3.game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window extends JFrame implements ActionListener {
    private final JPanel jPanel = new JPanel();
    private JLabel jLabel;

    public Window() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1));

        String[] buttonNames = {"Start", "Base"};
        for (String buttonName: buttonNames) {
            JButton jButton = new JButton(buttonName);
            jButton.addActionListener(this);
            jPanel.add(jButton);
        }
        container.add(jPanel);
        setTitle("Game");
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start")){
            jPanel.removeAll();
            jPanel.repaint();
        }
        if (e.getActionCommand().equals("Base")){
            jPanel.removeAll();
            jPanel.repaint();
        }

    }
}
