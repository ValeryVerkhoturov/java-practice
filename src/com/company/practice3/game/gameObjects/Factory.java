package com.company.practice3.game.gameObjects;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.equipment.Equipment;
import com.company.practice3.game.gameObjects.equipment.armor.Armor;
import com.company.practice3.game.gameObjects.equipment.weapons.Weapon;
import com.company.practice3.game.gameObjects.equipment.spells.Spell;
import java.util.ArrayList;

public class Factory {
    public static Character newDefaultCharacter(){
        return new Character("@", 100, newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }
    public static Equipment newRandomEquipment(){
        return new Equipment("Bag", newRandomWeapon(), newRandomArmor(), null);
    }
    public static Weapon newRandomWeapon(){
        return new Weapon(RandomParameters.weaponName(), RandomParameters.damage());
    }
    public static Armor newRandomArmor(){
        return new Armor(RandomParameters.armorName(), RandomParameters.def());
    }
}
