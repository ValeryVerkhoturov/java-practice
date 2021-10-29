package com.company.practice3.game.logic;

import com.company.practice3.game.objects.creatures.Character;
import com.company.practice3.game.objects.creatures.Mob;
import com.company.practice3.game.objects.equipment.Equipment;
import com.company.practice3.game.objects.expeditions.Coordinates;
import com.company.practice3.game.objects.expeditions.Field;
import lombok.experimental.UtilityClass;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class FightLogic {

    public void fight(Character character, Field field) throws Exception {
        Coordinates mobCoords = ExpeditionLogic.findCloseMob(character, field);
        Mob mob = (Mob) field.getCreature(mobCoords);
        while (character.isAlive() && mob.isAlive()){
            if(ThreadLocalRandom.current().nextBoolean()) {
                mob.takeDamage(character.getAtk() + character.getEquipment().getWeapon().getDamage());
                TimeUnit.MILLISECONDS.sleep(Math.round(character.getAtk()));
            }
            else {
                character.takeDamage(mob.getAtk() + mob.getEquipment().getWeapon().getDamage());
                TimeUnit.MILLISECONDS.sleep(Math.round(mob.getAtk()));
            }
        }
        if (!mob.isAlive())
            field.removeCreature(ExpeditionLogic.searchCreatureCoordinates(mob, field));
        if (character.isAlive())
            lootMob(character, mob);

    }

    public void autoFight(Character character, Mob mob) {
        while (character.isAlive() && mob.isAlive()){
            if(ThreadLocalRandom.current().nextBoolean()) {
                mob.takeDamage(character.getAtk() + character.getEquipment().getWeapon().getDamage());
            }
            else {
                character.takeDamage(mob.getAtk() + mob.getEquipment().getWeapon().getDamage());
            }
        }
        if (character.isAlive())
            lootMob(character, mob);
    }

    public void lootMob(Character character, Mob mob){
        Equipment charcterEquipment = character.getEquipment();
        Equipment mobEquipment = mob.getEquipment();
        if (mobEquipment.getWeapon().getDamage() > charcterEquipment.getWeapon().getDamage())
            charcterEquipment.setWeapon(mobEquipment.getWeapon());
        if (mobEquipment.getArmor().getDef() > charcterEquipment.getArmor().getDef())
            charcterEquipment.setArmor(mobEquipment.getArmor());
        while (mobEquipment.getSpells().size() > 0 && charcterEquipment.getSpells().size() < 3)
            charcterEquipment.addSpells(mobEquipment.getSpells());
    }
}
