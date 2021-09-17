package com.company.practice1;

public class Character {
    private String name;
    private int hp = 100;
    private int xp;
    private int level;
    private int attackPower;
    private int protectionLevel;

    /* Задание 2 */
    public boolean canBeEquiped(int requiredWeaponLevel){
        if (level < requiredWeaponLevel){
            System.out.println("Игрок не может экипировать оружие");
            return false;
        }
        System.out.println("Игрок может экипировать оружие");
        return true;
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

}
