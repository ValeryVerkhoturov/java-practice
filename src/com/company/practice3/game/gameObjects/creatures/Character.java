package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.equipment.Equipment;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class Character extends Creature {
    public Character(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }
    public String printStats(){
        return "Имя " + getName() + "\n" +
                "Здоровье " + getHp() + "\n" +
                "Оружие\n" +
                "  Имя " + getEquipment().getWeapon().getName() + "\n" +
                "  Урон" + getEquipment().getWeapon().getDamage() + "\n" +
                "Броня\n" +
                "  Имя " + getEquipment().getArmor().getName() + "\n" +
                "  Защита " + getEquipment().getArmor().getDef() + "\n" +
                "Атака " + getAtk() + "\n" +
                "Замах " + Math.round(getAps()) + "\n";
    }
    @Override
    public char viewOnMap() {
        return 'C'; // Character
    }
}
