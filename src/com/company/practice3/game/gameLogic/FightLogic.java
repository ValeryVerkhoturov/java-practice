package com.company.practice3.game.gameLogic;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightLogic {

    public static void fight(Character character, Field field) throws Exception {
        Coordinates mobCoords = ExpeditionLogic.findCloseMob(character, field);
        System.out.println("Mobcoords" + mobCoords);
        Mob mob = (Mob) field.getCreature(mobCoords);
        while (character.isAlive() && mob.isAlive()){
            if(ThreadLocalRandom.current().nextBoolean()) {
                mob.takeDamage(character.getAtk() + character.getEquipment().getWeapon().getDamage());
                System.out.println("Моб " + mob.getHp());
                TimeUnit.MILLISECONDS.sleep(100);
//                TimeUnit.MILLISECONDS.sleep(Math.round(character.getAtk()*100));
            }
            else {
                character.takeDamage(mob.getAtk() + mob.getEquipment().getWeapon().getDamage());
                System.out.println("Перс " + character.getHp());
                TimeUnit.MILLISECONDS.sleep(100);
//                TimeUnit.MILLISECONDS.sleep(Math.round(mob.getAtk()*100));
            }
        }
        if (!mob.isAlive())
            field.removeCreature(ExpeditionLogic.searchCreatureCoordinates(mob, field));
    }

}
