package com.company.practice2;

public class Character extends Attacker {
    private int xp;
    private int level;

    public Character(String name, int hp, int attackPower, int protectionLevel, int xp, int level, Weapon weapon){
        super(name, hp, attackPower, protectionLevel, weapon);
        this.xp = xp;
        this.level = level;
        this.weapon = weapon;
    }

    public boolean canBeEquiped(int requiredWeaponLevel){
        if (level < requiredWeaponLevel){
            System.out.println("Игрок не может экипировать оружие");
            return false;
        }
        System.out.println("Игрок может экипировать оружие");
        return true;
    }
    protected void setXp(int xp){
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
