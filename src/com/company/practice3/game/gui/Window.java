package com.company.practice3.game.gui;

import com.company.practice3.game.gameObjects.Factory;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.expeditions.Expedition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JPanel expedition;
    private JTable characterStats;
    private JLabel field;
    private JTextPane logs;
    private JButton base;
    private JButton start;

    public Window (JPanel expedition) {
        Container container = getContentPane();
        this.expedition = expedition;
        setTitle("Game");
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void createUIComponents() throws Exception {
        Character character = Factory.newDefaultCharacter();
        Expedition expedition = Factory.newRandomExpedition(character);
        Thread thread = new Thread(expedition);
        thread.start();
        field.setText(expedition.toString());
        // TODO: place custom component creation code here
    }
}
