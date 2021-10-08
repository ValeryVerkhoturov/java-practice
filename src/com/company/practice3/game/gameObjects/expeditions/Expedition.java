package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.creatures.Character;

import java.util.ArrayList;

public class Expedition {
    public Field field;
    public Character character;
    public ArrayList<Mob> mobs;

    public Expedition(Field field, Character character, ArrayList<Mob> mobs) {
        this.field = field;
        this.character = character;
        this.mobs = mobs;
    }
}
