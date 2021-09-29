package com.company.practice2;

public class Character extends Creature implements Attacker{
    private int xp;
    private int level;
    private Weapon weapon;

    public Character(String name, int hp, int attackPower, int protectionLevel, int xp, int level, Weapon weapon){
        super(name, hp, attackPower, protectionLevel);
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

    @Override
    public int attack() {
        return getAttackPower() + weapon.getAttackPower();
    }

    @Override
    public void defend(int damage) {
        damage -= getProtectionLevel();
        if (damage < 0)
            return;
        int hp = getHp() - damage;
        if (hp < 0)
            return;
        setHp(hp);
    }
    private void setHp(int hp){
        this.hp = hp;
    }
    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getXp(){
        return xp;
    }
    public int getLevel(){
        return level;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int getProtectionLevel(){
        return protectionLevel;
    }
    public Weapon getWeapon() {
        return weapon;
    }
}
