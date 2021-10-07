package com.company.practice3.game.gameObjects.equipment.armor;

import com.company.practice3.game.gameObjects.GameObject;

public class Armor extends GameObject {
    private int def;
    public Armor(String name, int def) {
        super(name);
        this.def = def;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
