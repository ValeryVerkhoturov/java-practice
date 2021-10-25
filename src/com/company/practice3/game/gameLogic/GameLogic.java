package com.company.practice3.game.gameLogic;

import java.util.concurrent.TimeUnit;

public class GameLogic {
    public static void samlingSleep(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
