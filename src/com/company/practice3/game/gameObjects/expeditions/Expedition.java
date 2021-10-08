package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.creatures.CharacterController;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.creatures.Character;

import java.util.ArrayList;

public class Expedition implements Runnable{
    private Field field;
    private Character character;
    private ArrayList<Mob> mobs;


    public Expedition(Field field, Character character, ArrayList<Mob> mobs) {
        this.field = field;
        this.character = character;
        this.mobs = mobs;
        this.field.insertRandomly(character);
        this.field.insertRandomly(mobs);

    }

    @Override
    public void run() {
        try {
            CharacterController characterController = new CharacterController(character, field);
            Thread characterThread = new Thread(characterController);
            characterThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return field.toString();
    }
}
