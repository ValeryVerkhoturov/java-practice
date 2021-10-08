package com.company.practice3.game.gameObjects.creatures;

import java.util.concurrent.TimeUnit;

public class CreatureController implements Runnable{
    private Creature creature;

    public CreatureController(Creature creature){
        this.creature = creature;
    }

    @Override
    public void run() {
        while(creature.getHp() > 0){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
