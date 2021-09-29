package com.company.practice2;

abstract class Creature extends Entity {
    protected int hp;
    protected int attackPower;
    protected int protectionLevel;
    public Creature(String name, int hp, int attackPower, int protectionLevel){
        super(name);
        this.hp = hp;
        this.attackPower = attackPower;
        this.protectionLevel = protectionLevel;
    }

    public int getHp() {
        return hp;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    protected void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    protected void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }
}
