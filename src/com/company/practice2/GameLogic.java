package com.company.practice2;

import java.util.Random;

public class GameLogic {
    public static int countDPS(int damage, int seconds){
        return damage/seconds;
    }
    public static int countDPS(int damage){
        Random random = new Random();
        return damage/(random.nextInt(2) + 1);
    }
}
