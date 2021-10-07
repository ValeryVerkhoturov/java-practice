package com.company.practice3.game.gameObjects.creatures.mobs;

import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.equipment.Equipment;

public class Mob extends Creature {

    public Mob(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }
}
