package com.company.practice2;

abstract class Creature extends Entity implements Attacker {
    protected int hp;
    protected int attackPower;
    protected int protectionLevel;
    public Creature(String name, int hp, int attackPower, int protectionLevel){
        super(name);
        this.hp = hp;
        this.attackPower = attackPower;
        this.protectionLevel = protectionLevel;
    }
}
