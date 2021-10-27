package com.company.practice3.game.gameObjects.equipment;

import com.company.practice3.game.gameObjects.GameObject;

public class Weapon extends GameObject {

    private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
