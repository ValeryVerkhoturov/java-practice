package com.company.practice3.game.gameObjects.equipment.spells;

import com.company.practice3.game.gameObjects.GameObject;

public class HealSpell extends GameObject implements Spell {

    private final int healStrength;

    public HealSpell(int healStrength){
        super("Лечащее заклинание");
        this.healStrength  = healStrength;
    }

    @Override
    public int cast() {
        return healStrength;
    }
}
