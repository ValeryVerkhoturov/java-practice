package com.company.practice2;

abstract class Entity {
    protected String name;
    public Entity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
