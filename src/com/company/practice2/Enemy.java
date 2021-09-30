package com.company.practice2;

import com.company.practice2.spells.SpellStorage;

public class Enemy extends Attacker {

    public Enemy(String name, int hp, int attackPower, int protectionLevel, Weapon weapon, SpellStorage<?, ?, ?> spellStorage){
        super(name, hp, attackPower, protectionLevel, weapon, spellStorage);
    }

}
