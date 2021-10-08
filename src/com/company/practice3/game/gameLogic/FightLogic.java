package com.company.practice3.game.gameLogic;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

import java.util.Random;

public class FightLogic {
    public static int countDPS(Creature creature){
        return (int)(creature.getAtk() * creature.getEquipment().getWeapon().getDamage() * creature.getAps());
    }

    public static void fight(Character character, Mob mob){
        boolean attackDirection = new Random().nextBoolean();
        while (character.isAlive() && mob.isAlive()){
            if(attackDirection)
                mob.takeDamage(character.getAtk() + character.getEquipment().getWeapon().getDamage());
            else
                character.takeDamage(mob.getAtk() + mob.getEquipment().getWeapon().getDamage());
        }
    }

}
