package com.company.practice2;


import com.company.practice2.spells.*;

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
        return new Character("Unnamed character", 100, 0, 0, 0, 0, createDefaultWeapon(), createRandomSpellStorage());
    }
    public static Character createRandomCharacter(){
        return new Character(
                GameRandom.createCharacterName(),
                GameRandom.createHp(),
                GameRandom.createAttackPower(),
                GameRandom.createProtectionLevel(),
                GameRandom.createXp(),
                GameRandom.createLevel(),
                createRandomWeapon(),
                createRandomSpellStorage());
    }

    public static Enemy createDefaultEnemy(){
        return new Enemy("Unnamed enemy", 100, 0, 0, createDefaultWeapon(), createRandomSpellStorage());
    }
    public static Enemy createRandomEnemy(){
        return new Enemy(
                GameRandom.createEnemyName(),
                GameRandom.createHp(),
                GameRandom.createAttackPower(),
                GameRandom.createProtectionLevel(),
                createRandomWeapon(),
                createRandomSpellStorage());
    }
    public static DamagingElement createRandomDamagingElement(){
        Random random = new Random();
        switch (random.nextInt(5)){
            case 0:
                return new AirElement();
            case 1:
                return new EarthElement();
            case 2:
                return new EtherElement();
            case 3:
                return new FireElement();
            case 4:
                return new FrostElement();
            default:
                return new WaterElement();
        }
    }
    public static DamagingSpell<?> createRandomDamagingSpell(){
        return new DamagingSpell<>(createRandomDamagingElement());
    }
    public static SpellStorage<?, ?, ?> createRandomSpellStorage(){
        return new SpellStorage(createRandomDamagingSpell(), createRandomDamagingSpell(), createRandomDamagingSpell());
    }
}
