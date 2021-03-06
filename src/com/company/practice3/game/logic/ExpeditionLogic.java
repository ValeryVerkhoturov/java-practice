package com.company.practice3.game.logic;

import com.company.practice3.game.objects.creatures.Character;
import com.company.practice3.game.objects.creatures.Creature;
import com.company.practice3.game.objects.creatures.Mob;
import com.company.practice3.game.objects.expeditions.Coordinates;
import com.company.practice3.game.objects.expeditions.Field;
import lombok.experimental.UtilityClass;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class ExpeditionLogic {

    public void expeditionLoop(Character character, Field field) throws Exception {
        Coordinates mobCoordinates = findCloseMob(character, field);
        while (mobCoordinates != null && character.isAlive()){
            goToMob(character, field);
            FightLogic.fight(character, field);
            character.castHealSpell();
            mobCoordinates = findCloseMob(character, field);
        }
    }

    public Coordinates searchCreatureCoordinates(Creature creature, Field field) throws Exception {
        for (int i = 0; i < field.getField().length; i++)
            for (int j = 0; j < field.getField()[0].length; j++)
                if (field.getField()[i][j] == creature)
                    return new Coordinates(j, i);
        throw new Exception("Character cannot find himself");
    }

    public Coordinates findCloseMob(Character character, Field field) throws Exception {
        Coordinates characterCoords = searchCreatureCoordinates(character, field);
        double minDistance = Math.max(field.getRows(), field.getCols());
        Coordinates closeMobCoords = null;
        for (int i = 0; i < field.getField().length; i++)
            for (int j = 0; j < field.getField()[0].length; j++)
                if (field.getField()[i][j] instanceof Mob)
                    if (minDistance > characterCoords.distanceTo(new Coordinates(j, i))){
                        minDistance = characterCoords.distanceTo(new Coordinates(j, i));
                        closeMobCoords = new Coordinates(j, i);
                    }
        return closeMobCoords;
    }

    public void goToMob(Character  character, Field field) throws Exception {
        Coordinates characterCoords = searchCreatureCoordinates(character, field);
        Coordinates mobCoords = findCloseMob(character, field);
        while (Math.abs(characterCoords.getX() - mobCoords.getX()) > 1 || Math.abs(characterCoords.getY() - mobCoords.getY()) > 1 ||
                Math.abs(characterCoords.getX() - mobCoords.getX()) + Math.abs(characterCoords.getY() - mobCoords.getY()) > 1){
            if (ThreadLocalRandom.current().nextBoolean()) {
                if (mobCoords.getX() > characterCoords.getX())
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX() + 1, characterCoords.getY()));
                else if (mobCoords.getX() < characterCoords.getX())
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX() - 1, characterCoords.getY()));
            } else {
                if (mobCoords.getY() > characterCoords.getY())
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX(), characterCoords.getY() + 1));
                else if (mobCoords.getY() < characterCoords.getY())
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX(), characterCoords.getY() - 1));
            }
            characterCoords = searchCreatureCoordinates(character, field);
            mobCoords = findCloseMob(character, field);
            TimeUnit.MILLISECONDS.sleep(400);
        }
    }
}
