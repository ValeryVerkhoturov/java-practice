package com.company.practice3.game.gameObjects;

import java.util.Random;

class RandomParameters {
    private static final Random random = new Random();
    private final static String[] creatureNames = {
            "Lynn Mcnally", "Michael Devereux", "Lurker Kanti", "Ben Radcliff", "Ankle-nibbler Drake",
            "Clamper Shadow", "Gage Whitlock", "Crimson Lynn", "Dead-head Dracula"};
    private final static String[] weaponNames = {
            "Unholy Might", "Scalpel", "Shadowsteel", "Timeworn Defender", "Stormguard Katana",
            "Diamond Spellblade", "Scar", " Carver of Darkness"};
    private final static String[] armorNames = {"Chestplate of Doomed Comrades", "Batteplate of Punishment",
            "Iron Tunic", "Skeletal Chestplate", "Oathkeeper's Cuirass", "Desolation Cuirass"};
    public static String creatureName(){
        return creatureNames[random.nextInt(creatureNames.length)];
    }
    public static String weaponName(){
        return weaponNames[random.nextInt(weaponNames.length)];
    }
    public static String armorName(){
        return armorNames[random.nextInt(armorNames.length)];
    }
    public static int damage(){
        return random.nextInt(15) + 15;
    }
    public static int hp(){
        return random.nextInt(25) + 25;
    }
    public static int atk(){
        return random.nextInt(5) + 20;
    }
    public static double aps(){
        return random.nextDouble() + 0.5;
    }
    public static int def(){
        return random.nextInt(5);
    }
    public static int rows(){
        return random.nextInt(5) + 6;
    }
    public static int cols(){
        return random.nextInt(5) + 6;
    }
    public static int mobsAmmount(){
        return random.nextInt(5) + 5;
    }
    public static int healStrength(){
        return random.nextInt(5) + 1;
    }
    public static int spellAmmount(){
        return random.nextInt(3);
    }
}
