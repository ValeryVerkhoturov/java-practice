package com.company.practice3.game.gameLogic;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ExpeditionLogic {
    public static void expeditionLoop(Character character, Field field) throws Exception {
        Coordinates mobCoordinates = findCloseMob(character, field);
        while (mobCoordinates != null){
            System.out.println(searchCreatureCoordinates(character, field));
            goToMob(character, field);
            System.out.println(searchCreatureCoordinates(character, field));
            TimeUnit.MILLISECONDS.sleep(500);
//            fight(character, field);
            mobCoordinates = findCloseMob(character, field);
        }
    }
    public static Coordinates searchCreatureCoordinates(Creature creature, Field field) throws Exception {
        for (int i = 0; i < field.getField().length; i++)
            for (int j = 0; j < field.getField()[0].length; j++)
                if (field.getField()[i][j] == creature)
                    return new Coordinates(j, i);
        throw new Exception("Character cannot find himself");
    }

    public static Coordinates findCloseMob(Character character, Field field) throws Exception {
        Coordinates startCoords = searchCreatureCoordinates(character, field);
        double minDistance = Math.max(field.getRows(), field.getCols());
        Coordinates closeMobCoords = null;
        for (int i = 0; i < field.getField().length; i++)
            for (int j = 0; j < field.getField()[0].length; j++)
                if (field.getField()[i][j] instanceof Mob)
                    if (minDistance > startCoords.distanceTo(new Coordinates(j, i))){
                        minDistance = startCoords.distanceTo(new Coordinates(j, i));
                        closeMobCoords = new Coordinates(j, i);
                    }
        return closeMobCoords;
    }

    public static void goToMob(Character  character, Field field) throws Exception {
        Coordinates characterCoords = searchCreatureCoordinates(character, field);
        Coordinates mobCoords = findCloseMob(character, field);
        while (Math.abs(characterCoords.getX() - mobCoords.getX()) > 1 && Math.abs(characterCoords.getY() - mobCoords.getY()) > 1){
            if (ThreadLocalRandom.current().nextInt(2) == 0) {
                if (mobCoords.getX() > characterCoords.getX())
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX() + 1, characterCoords.getY()));
                else
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX() - 1, characterCoords.getY()));
            } else {
                if (mobCoords.getY() > characterCoords.getY())
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX(), characterCoords.getY() + 1));
                else
                    field.moveCell(characterCoords, new Coordinates(characterCoords.getX(), characterCoords.getY() - 1));
            }
            characterCoords = searchCreatureCoordinates(character, field);
            mobCoords = findCloseMob(character, field);
        }
    }
}
