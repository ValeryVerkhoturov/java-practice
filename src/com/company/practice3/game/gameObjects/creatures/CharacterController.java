package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class CharacterController extends CreatureController {
    private Character character;
    private Field field;
    private Coordinates coordinates;

    public CharacterController(Character character, Field field) throws Exception {
        super(character);
        this.field = field;
        this.coordinates = searchCurrentCoordinates();
        System.out.println(coordinates);
    }

    @Override
    public void run() {
        super.run();
    }

    private Coordinates searchCurrentCoordinates() throws Exception {
        for (int i = 0; i < field.getField().length; i++){
            for (int j = 0; j < field.getField().length; j++) {
                if (field.getField()[j][i] == character)
                    return new Coordinates(i, j);
            }
        }
        throw new Exception("Character cannot find himself");
    }
}
