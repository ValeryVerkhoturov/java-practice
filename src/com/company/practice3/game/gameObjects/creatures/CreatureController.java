package com.company.practice3.game.gameObjects.creatures;

import java.util.concurrent.TimeUnit;

public abstract class CreatureController implements Runnable{
    private Creature creature;

    public CreatureController(Creature creature){
        this.creature = creature;
    }
    public CreatureController(Mob mob){
        this.creature = mob;
    }
    public CreatureController(Character character){
        this.creature = character;
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
