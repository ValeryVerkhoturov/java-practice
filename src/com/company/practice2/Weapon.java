package com.company.practice2;


public class Weapon extends Item{
    private int attackPower;
    private int requiredLevel;

    public Weapon(String name, int price, int attackPower, int requiredLevel){
        super(name, price);


        this.attackPower = attackPower;
        this.requiredLevel = requiredLevel;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getPrice() {
        return price;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }
}
