package com.company.practice3;


import com.company.practice3.game.gameObjects.Factory;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.expeditions.Expedition;
import com.company.practice3.game.gui.Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{
    public void main(){
        new Window(new JPanel());
//        Character character = Factory.newDefaultCharacter();
//        Expedition expedition = Factory.newRandomExpedition(character);
//        Thread thread = new Thread(expedition);
//        thread.start();
//        System.out.println(expedition);
    }
}
