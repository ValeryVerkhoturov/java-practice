package com.company.practice3.game.gui;

import javafx.application.Platform;
import lombok.Value;

import java.util.concurrent.TimeUnit;

@Value
public class BaseAnimationController implements Runnable {

    GameController gameController;

    @Override
    public void run() {
        String[] asciiArt = AsciiArt.baseAnimation;
        while (true){
            if (!gameController.getCharacter().isAlive() && !gameController.getMutex().isLocked()){
                Platform.runLater(() -> gameController.getExpedition().setDisable(true));
                Platform.runLater(() -> gameController.getAutoExpedition().setDisable(true));
                asciiArt = AsciiArt.deathAnimation;
            }
            for (String art: asciiArt) {
                if (!gameController.getMutex().isLocked())
                    Platform.runLater(() -> gameController.getBattleField().setText(art));
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
