package com.company.practice3.game.gui;

import com.company.practice3.game.gameObjects.creatures.Character;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BaseAnimationController implements Runnable {

    private final Character character;

    private final Label label;

    private final ReentrantLock lock;

    private final Button expedition;

    private final Button autoExpedition;

    public BaseAnimationController(Label label, ReentrantLock lock, Character character, Button expedition, Button autoExpedition){
        this.label = label;
        this.lock = lock;
        this.character = character;
        this.expedition = expedition;
        this.autoExpedition = autoExpedition;
    }

    @Override
    public void run() {
        while (true){
            if (!character.isAlive() && !lock.isLocked()){
                Platform.runLater(() -> label.setText(ASCIIart.death));
                Platform.runLater(() -> expedition.setDisable(true));
                Platform.runLater(() -> autoExpedition.setDisable(true));
                return;
            }
            for (String art: ASCIIart.baseAnimation) {
                if (!lock.isLocked())
                    Platform.runLater(() -> label.setText(art));
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
