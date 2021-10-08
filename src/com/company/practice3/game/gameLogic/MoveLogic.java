package com.company.practice3.game.gameLogic;

import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class MoveLogic {
    public static Coordinates searchCreatureCoordinates(Creature creature, Field field) throws Exception {
        for (int i = 0; i < field.getField().length; i++)
            for (int j = 0; j < field.getField()[0].length; j++)
                if (field.getField()[i][j] == creature)
                    return new Coordinates(j, i);
        throw new Exception("Character cannot find itself");
    }
}
