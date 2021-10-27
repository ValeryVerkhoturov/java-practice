package com.company.practice3.game.gameObjects;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.equipment.Equipment;
import com.company.practice3.game.gameObjects.equipment.Armor;
import com.company.practice3.game.gameObjects.equipment.Weapon;
import com.company.practice3.game.gameObjects.equipment.spells.HealSpell;
import com.company.practice3.game.gameObjects.equipment.spells.Spell;
import com.company.practice3.game.gameObjects.expeditions.ExpeditionController;
import com.company.practice3.game.gameObjects.expeditions.Field;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Factory {
    public static Character newDefaultCharacter(){
        return new Character(RandomParameters.creatureName(), 100, newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }
    public static Mob newRandomMob(){
        return new Mob(RandomParameters.creatureName(), RandomParameters.hp(), newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }
    public static ArrayList<Mob> newRandomMobs(){
        ArrayList<Mob> mobs = new ArrayList<>();
        for (int i = 0; i < RandomParameters.mobsAmmount(); i++){
            mobs.add(newRandomMob());
        }
        return mobs;
    }
    public static Equipment newRandomEquipment(){
        return new Equipment("Bag", newRandomWeapon(), newRandomArmor(), newArrayListOfSpells());
    }
    public static ArrayList<Spell> newArrayListOfSpells(){
        ArrayList<Spell> spells  = new ArrayList<>();
        for (int i = 0; i < RandomParameters.spellAmmount(); i++)
            spells.add(new HealSpell(RandomParameters.healStrength()));
        return spells;
    }
    public static Weapon newRandomWeapon(){
        return new Weapon(RandomParameters.weaponName(), RandomParameters.damage());
    }
    public static Armor newRandomArmor(){
        return new Armor(RandomParameters.armorName(), RandomParameters.def());
    }
    public static Field newRandomField() throws Exception {
        return new Field("Random Game Field", RandomParameters.rows(), RandomParameters.cols());
    }
    public static ExpeditionController newRandomExpeditionController(Character character, Label field, Label equipment, Button expeditionButton, Button autoExpeditionButton, ReentrantLock lock) throws Exception {
        return new ExpeditionController(newRandomField(), character, newRandomMobs(), field, equipment, expeditionButton, autoExpeditionButton, lock);
    }
}
