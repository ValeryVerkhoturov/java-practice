package com.company.practice2;

public class Enemy extends Creature implements Attacker {
    private Weapon weapon;

    public Enemy(String name, int hp, int attackPower, int protectionLevel, Weapon weapon){
        super(name, hp, attackPower, protectionLevel);
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public void defend(int damage) {

    }
}
