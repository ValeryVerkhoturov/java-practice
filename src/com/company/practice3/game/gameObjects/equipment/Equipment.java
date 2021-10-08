package com.company.practice3.game.gameObjects.equipment;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.equipment.spells.Spell;

import java.util.ArrayList;


public class Equipment extends GameObject {
    private Weapon weapon;
    private Armor armor;
    private ArrayList<Spell> spells;
    public Equipment(String name, Weapon weapon, Armor armor, ArrayList<Spell> spells) {
        super(name);
        this.weapon = weapon;
        this.armor = armor;
        this.spells = spells;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    @Override
    public char viewOnMap() {
        return 'E';
    }
}
