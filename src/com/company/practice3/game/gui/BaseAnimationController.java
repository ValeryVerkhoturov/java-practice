package com.company.practice3.game.gui;

import com.company.practice3.game.objects.creatures.Character;
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
        String[] asciiArt = AsciiArt.baseAnimation;
        while (true){
            if (!character.isAlive() && !lock.isLocked()){
                Platform.runLater(() -> expedition.setDisable(true));
                Platform.runLater(() -> autoExpedition.setDisable(true));
                asciiArt = AsciiArt.deathAnimation;
            }
            for (String art: asciiArt) {
                if (!lock.isLocked())
                    Platform.runLater(() -> field.setText(art));
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
