package com.company.practice3.game.objects.creatures;

import com.company.practice3.game.objects.equipment.Equipment;

public class Mob extends Creature {

    public Mob(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }

    @Override
    public char viewOnMap() {
        return 'M'; // Mob
    }
}
