package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.equipment.Equipment;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class Character extends Creature {
    private Field field;
    public Character(String name, int hp, Equipment equipment, int atk, double aps, Field field) {
        super(name, hp, equipment, atk, aps);
    }

    @Override
    public char viewOnMap() {
        return 'C'; // Character
    }
}
