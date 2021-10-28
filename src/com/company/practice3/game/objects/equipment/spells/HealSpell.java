package com.company.practice3.game.objects.equipment.spells;

import com.company.practice3.game.objects.GameObject;

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
