package com.company.practice2;


public class Weapon extends Item{
    private int attackPower;
    private int requiredLevel;

    public Weapon(String name, int price, int attackPower, int requiredLevel){
        super(name, price);


        this.attackPower = attackPower;
        this.requiredLevel = requiredLevel;
    }

    public int getAttackPower() {
        return attackPower;
    }

    protected void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    protected void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
