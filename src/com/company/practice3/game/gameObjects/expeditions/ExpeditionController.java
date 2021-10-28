package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.creatures.CharacterController;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.creatures.Character;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Data;
import lombok.NonNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class ExpeditionController implements Runnable{

    @NonNull private final Field field;

    @NonNull private final Character character;

    @NonNull private final Label fieldLbl;

    @NonNull private final Label equipmentLbl;

    @NonNull private final Button expeditionBtn;

    @NonNull private final Button autoExpeditionBtn;

    @NonNull private final ReentrantLock lock;

    @Override
    public void run() {
        if(!character.isAlive())
            return;
        lock.lock();
        Platform.runLater(() -> expeditionBtn.setDisable(true));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(true));
        Platform.runLater(() -> fieldLbl.setText(field.toString()));
        Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        try {
            Thread characterThread = new Thread(new CharacterController(character, field));
            characterThread.setName("Персонаж");
            characterThread.setDaemon(true);
            characterThread.start();
            while (characterThread.isAlive()){
                Platform.runLater(() -> fieldLbl.setText(field.toString()));
                Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
                TimeUnit.MILLISECONDS.sleep(50);
            }
            Platform.runLater(() -> fieldLbl.setText(field.toString()));
            Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> expeditionBtn.setDisable(false));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(false));
        lock.unlock();
    }
}
