package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.equipment.Equipment;

public class Mob extends Creature {

    public Mob(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }

    @Override
    public java.lang.Character viewOnMap() {
        return 'M'; // Mob
    }
}
