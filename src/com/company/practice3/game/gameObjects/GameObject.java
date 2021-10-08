package com.company.practice3.game.gameObjects;

public abstract class GameObject {
    private String name;

    public GameObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character viewOnMap(){
        return 'U'; // Undefined
    }
}