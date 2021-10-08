package com.company.practice3.game.gameObjects;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.equipment.Equipment;
import com.company.practice3.game.gameObjects.equipment.Armor;
import com.company.practice3.game.gameObjects.equipment.Weapon;
import com.company.practice3.game.gameObjects.expeditions.Expedition;
import com.company.practice3.game.gameObjects.expeditions.Field;

import java.util.ArrayList;

public class Factory {
    public static Character newDefaultCharacter(){
        return new Character("@", 100, newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }
    public static Mob newRandomMob(){
        return new Mob(RandomParameters.creatureName(), RandomParameters.hp(), newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }
    public static ArrayList<Mob> newRandomMobs(){
        ArrayList<Mob> mobs = new ArrayList<Mob>();
        for (int i = 0; i < RandomParameters.mobsAmmount(); i++){
            mobs.add(newRandomMob());
        }
        return mobs;
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
    public static Field newRandomField(){
        return new Field("Random Game Field", RandomParameters.rows(), RandomParameters.cols());
    }
    public static Expedition newRandomExpedition(Character character){
        return new Expedition(newRandomField(), character, newRandomMobs());
    }
}
