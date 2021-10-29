package com.company.practice3.game.objects.creatures;

import com.company.practice3.game.logic.ExpeditionLogic;
import com.company.practice3.game.objects.expeditions.Field;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacterController implements Runnable{

    Field field;

    Character character;

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
