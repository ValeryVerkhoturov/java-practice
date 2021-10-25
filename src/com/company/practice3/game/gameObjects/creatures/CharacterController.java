package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameLogic.GameLogic;
import com.company.practice3.game.gameLogic.ExpeditionLogic;
import com.company.practice3.game.gameObjects.expeditions.Coordinates;
import com.company.practice3.game.gameObjects.expeditions.Field;


public class CharacterController implements Runnable{
    private Field field;
    private Character character;

    public CharacterController(Character character, Field field) {
        this.character = character;
        this.field = field;
    }

    @Override
    public void run() {
        try {
            ExpeditionLogic.expeditionLoop(character, field);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
