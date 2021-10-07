package com.company.practice3.game.gameObjects.equipment;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.equipment.armor.Armor;
import com.company.practice3.game.gameObjects.equipment.spells.Spell;
import com.company.practice3.game.gameObjects.equipment.weapons.Weapon;

import java.util.ArrayList;


public class Equipment<W extends Weapon, A extends Armor, S extends ArrayList<Spell>> extends GameObject {
    private W weapon;
    private A armor;
    private S spells;
    public Equipment(String name, W weapon, A armor, S spells) {
        super(name);
        this.weapon = weapon;
        this.armor = armor;
        this.spells = spells;
    }

    public W getWeapon() {
        return weapon;
    }

    public void setWeapon(W weapon) {
        this.weapon = weapon;
    }

    public A getArmor() {
        return armor;
    }

    public void setArmor(A armor) {
        this.armor = armor;
    }

    public S getSpells() {
        return spells;
    }

    public void setSpells(S spells) {
        this.spells = spells;
    }
}
