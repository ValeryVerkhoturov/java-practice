package com.company.practice3.game.objects.creatures;

import com.company.practice3.game.logic.ExpeditionLogic;
import com.company.practice3.game.objects.expeditions.Field;
import lombok.Value;

@Value
public class CharacterController implements Runnable{

    Character character;

    Field field;

    @Override
    public void run() {
        try {
            ExpeditionLogic.expeditionLoop(character, field);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
