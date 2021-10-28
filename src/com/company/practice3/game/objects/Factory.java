package com.company.practice3.game.objects;

import com.company.practice3.game.objects.creatures.Character;
import com.company.practice3.game.objects.creatures.Mob;
import com.company.practice3.game.objects.equipment.Equipment;
import com.company.practice3.game.objects.equipment.Armor;
import com.company.practice3.game.objects.equipment.Weapon;
import com.company.practice3.game.objects.equipment.spells.HealSpell;
import com.company.practice3.game.objects.equipment.spells.Spell;
import com.company.practice3.game.objects.expeditions.AutoExpeditionController;
import com.company.practice3.game.objects.expeditions.ExpeditionController;
import com.company.practice3.game.objects.expeditions.Field;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

@UtilityClass
public class Factory {

    public Character newDefaultCharacter(){
        return new Character(RandomParameters.creatureName(), 100, newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }

    public Mob newRandomMob(){
        return new Mob(RandomParameters.creatureName(), RandomParameters.hp(), newRandomEquipment(), RandomParameters.atk(), RandomParameters.aps());
    }

    public ArrayList<Mob> newRandomMobs(){
        ArrayList<Mob> mobs = new ArrayList<>();
        for (int i = 0; i < RandomParameters.mobsAmmount(); i++){
            mobs.add(newRandomMob());
        }
        return mobs;
    }

    public Equipment newRandomEquipment(){
        return new Equipment("Bag", newRandomWeapon(), newRandomArmor(), newArrayListOfSpells());
    }

    public ArrayList<Spell> newArrayListOfSpells(){
        ArrayList<Spell> spells  = new ArrayList<>();
        for (int i = 0; i < RandomParameters.spellAmmount(); i++)
            spells.add(new HealSpell(RandomParameters.healStrength()));
        return spells;
    }

    public Weapon newRandomWeapon(){
        return new Weapon(RandomParameters.weaponName(), RandomParameters.damage());
    }

    public Armor newRandomArmor(){
        return new Armor(RandomParameters.armorName(), RandomParameters.def());
    }

    public Field newRandomField() throws Exception {
        return new Field("Random Game Field", RandomParameters.rows(), RandomParameters.cols());
    }

    public ExpeditionController newRandomExpeditionController(Character character, Label field, Label equipment, Button expeditionButton, Button autoExpeditionButton, ReentrantLock lock) throws Exception {
        Field fieldForCharacterAndMobs = newRandomField();
        fieldForCharacterAndMobs.insertRandomly(character);
        fieldForCharacterAndMobs.insertRandomly(newRandomMobs());
        return new ExpeditionController(fieldForCharacterAndMobs, character, field, equipment, expeditionButton, autoExpeditionButton, lock);
    }

    public AutoExpeditionController newRandomAutoExpedtionController(Character character, Label field, Label equipment, Button expeditionButton, Button autoExpedition, ReentrantLock lock){
        return new AutoExpeditionController(character, field, equipment, expeditionButton, autoExpedition, lock, newRandomMob());
    }
}
