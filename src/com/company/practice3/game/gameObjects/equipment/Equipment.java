package com.company.practice3.game.gameObjects.equipment;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.equipment.spells.Spell;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
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

    public void addSpells(ArrayList<Spell> spells){
        this.spells.addAll(spells);
    }

    @Override
    public char viewOnMap() {
        return 'E';
    }
}
