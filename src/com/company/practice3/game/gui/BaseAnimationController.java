package com.company.practice3.game.gui;

import com.company.practice3.game.gameObjects.creatures.Character;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Data;
import lombok.NonNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class BaseAnimationController implements Runnable {

    @NonNull private final Character character;

    @NonNull private final Label field;

    @NonNull private final Button expedition;

    @NonNull private final Button autoExpedition;

    @NonNull private final ReentrantLock lock;

    @Override
    public void run() {
        while (true){
            if (!character.isAlive() && !lock.isLocked()){
                Platform.runLater(() -> field.setText(AsciiArt.death));
                Platform.runLater(() -> expedition.setDisable(true));
                Platform.runLater(() -> autoExpedition.setDisable(true));
                return;
            }
            for (String art: AsciiArt.baseAnimation) {
                if (!lock.isLocked())
                    Platform.runLater(() -> field.setText(art));
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
