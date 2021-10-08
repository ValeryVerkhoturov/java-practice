package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameLogic.MoveLogic;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;

public class CharacterController extends CreatureController {
    private Field field;
    private Coordinates coordinates;

    public CharacterController(Character character, Field field) throws Exception {
        super(character);
        this.field = field;
        this.coordinates = MoveLogic.searchCreatureCoordinates(creature, field);

    }

    @Override
    public void run() {
        super.run();
    }
}
