package com.company.practice3.game.gameObjects.creatures.character;

import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.equipment.Equipment;

public class Character extends Creature {
    public Character(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }
}
