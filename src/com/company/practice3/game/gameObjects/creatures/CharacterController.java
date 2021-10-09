package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameLogic.GameLogic;
import com.company.practice3.game.gameLogic.ExpeditionLogic;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;


public class CharacterController extends CreatureController {
    // remove field, coordinates
    private Field field;
    private Coordinates coordinates;

    public CharacterController(Character character, Field field) throws Exception {
        super(character);
        this.field = field;
        this.coordinates = ExpeditionLogic.searchCreatureCoordinates(creature, field);
    }

    @Override
    public void run() {
        try {
            field.moveCell(coordinates, new Coordinates(2, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(field);
        while(creature.getHp() > 0){
            GameLogic.samlingSleep();
        }
    }
}
