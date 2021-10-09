package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameLogic.GameLogic;

import java.util.concurrent.TimeUnit;

public abstract class CreatureController implements Runnable{
    protected Creature creature;

    public CreatureController(Mob mob){
        this.creature = mob;
    }
    public CreatureController(Character character){
        this.creature = character;
    }

    @Override
    public void run() {
        GameLogic.samlingSleep();
    }
}
