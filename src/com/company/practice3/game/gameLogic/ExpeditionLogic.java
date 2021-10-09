package com.company.practice3.game.gameLogic;

import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class ExpeditionLogic {
    public static void expeditionLoop(Character character, Field field) throws Exception {
        Coordinates characterCoordinates = searchCreatureCoordinates(character, field);
        do {
            Coordinates mobCoordinates = findCloseMob(characterCoordinates, field);
            if (mobCoordinates == null)
                break;
            // TODO
        } while (true);
    }
    public static Coordinates searchCreatureCoordinates(Creature creature, Field field) throws Exception {
        for (int i = 0; i < field.getField().length; i++)
            for (int j = 0; j < field.getField()[0].length; j++)
                if (field.getField()[i][j] == creature)
                    return new Coordinates(j, i);
        throw new Exception("Character cannot find itself");
    }

    public static Coordinates findCloseMob(Coordinates startCoords, Field field) {
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

//    public static Coordinates goToMob(Coordinates characterCoords, Coordinates mobCoords, Field field){
//
//    }
}
