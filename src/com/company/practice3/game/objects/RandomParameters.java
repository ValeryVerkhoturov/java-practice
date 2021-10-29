package com.company.practice3.game.objects;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
class RandomParameters {

    private final Random random = new Random();

    private final String[] creatureNames = {
            "Lynn Mcnally", "Michael Devereux", "Lurker Kanti", "Ben Radcliff", "Ankle-nibbler Drake",
            "Clamper Shadow", "Gage Whitlock", "Crimson Lynn", "Dead-head Dracula"};

    private final String[] weaponNames = {
            "Unholy Might", "Scalpel", "Shadowsteel", "Timeworn Defender", "Stormguard Katana",
            "Diamond Spellblade", "Scar", " Carver of Darkness"};

    private final String[] armorNames = {"Chestplate of Doomed Comrades", "Batteplate of Punishment",
            "Iron Tunic", "Skeletal Chestplate", "Oathkeeper's Cuirass", "Desolation Cuirass"};

    public String creatureName(){
        return creatureNames[random.nextInt(creatureNames.length)];
    }

    public String weaponName(){
        return weaponNames[random.nextInt(weaponNames.length)];
    }

    public String armorName(){
        return armorNames[random.nextInt(armorNames.length)];
    }

    public int damage(){
        return random.nextInt(10) + 5;
    }

    public int hp(){
        return random.nextInt(25) + 25;
    }

    public int atk(){
        return random.nextInt(5) + 30;
    }

    public double aps(){
        return random.nextDouble() + 0.5;
    }

    public int def(){
        return random.nextInt(10) + 1;
    }

    public int rows(){
        return random.nextInt(5) + 6;
    }

    public int cols(){
        return random.nextInt(5) + 6;
    }

    public int mobsAmmount(){
        return random.nextInt(2) + 3;
    }

    public int healStrength(){
        return random.nextInt(5) + 1;
    }

    public int spellAmmount(){
        return random.nextInt(3);
    }
}
