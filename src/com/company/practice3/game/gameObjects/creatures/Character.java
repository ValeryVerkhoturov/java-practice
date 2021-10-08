package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.equipment.Equipment;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class Character extends Creature {
    public Character(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }

    @Override
    public char viewOnMap() {
        return 'C'; // Character
    }
}
