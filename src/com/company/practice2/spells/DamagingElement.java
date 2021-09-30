package com.company.practice2.spells;

public abstract class DamagingElement implements Element {
    protected String name;
    protected int damage;

    public DamagingElement(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }
}
