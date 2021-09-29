package com.company.practice2;

import java.util.Random;

public class Factory {
    public static Weapon createDefaultWeapon(){
        return new Weapon("Unnamed weapon", 0, 0, 0);
    }
    public static Weapon createRandomWeapon(){
        return new Weapon(
                GameRandom.createWeaponName(),
                GameRandom.createPrice(),
                GameRandom.createAttackPower(),
                GameRandom.createRequiredLevel());
    }

    public static Character createDefaulyCharacter(){
        return new Character("Unnamed character", 100, 0, 0, 0, 0, createDefaultWeapon());
    }
    public static Character createRandomCharacter(){
        return new Character(
                GameRandom.createCharacterName(),
                GameRandom.createHp(),
                GameRandom.createAttackPower(),
                GameRandom.createProtectionLevel(),
                GameRandom.createXp(),
                GameRandom.createLevel(),
                createRandomWeapon());
    }

    public static Enemy createDefaultEnemy(){
        return new Enemy("Unnamed enemy", 100, 0, 0, createDefaultWeapon());
    }
    public static Enemy createRandomEnemy(){
        return new Enemy(
                GameRandom.createEnemyName(),
                GameRandom.createHp(),
                GameRandom.createAttackPower(),
                GameRandom.createProtectionLevel(),
                createRandomWeapon());
    }
}
