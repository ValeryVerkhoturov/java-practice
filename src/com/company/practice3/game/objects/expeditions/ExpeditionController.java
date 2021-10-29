package com.company.practice3.game.objects.expeditions;

import com.company.practice3.game.gui.GameController;
import com.company.practice3.game.objects.creatures.CharacterController;
import com.company.practice3.game.objects.creatures.Character;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Value
public class ExpeditionController implements Runnable{

    Field field;

    GameController gameController;

    @Override
    public void run() {
        if(!gameController.getCharacter().isAlive())
            return;
        gameController.getMutex().lock();
        Platform.runLater(() -> gameController.getExpedition().setDisable(true));
        Platform.runLater(() -> gameController.getAutoExpedition().setDisable(true));
        Platform.runLater(() -> gameController.getBattleField().setText(field.toString()));
        Platform.runLater(() -> gameController.getEquipment().setText(gameController.getCharacter().printStats()));
        try {
            Thread characterThread = new Thread(new CharacterController(gameController.getCharacter(), field));
            characterThread.setName("Персонаж");
            characterThread.setDaemon(true);
            characterThread.start();
            while (characterThread.isAlive()){
                Platform.runLater(() -> gameController.getBattleField().setText(field.toString()));
                Platform.runLater(() -> gameController.getEquipment().setText(gameController.getCharacter().printStats()));
                TimeUnit.MILLISECONDS.sleep(50);
            }
            Platform.runLater(() -> gameController.getBattleField().setText(field.toString()));
            Platform.runLater(() -> gameController.getEquipment().setText(gameController.getCharacter().printStats()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> gameController.getExpedition().setDisable(false));
        Platform.runLater(() -> gameController.getAutoExpedition().setDisable(false));
        gameController.getMutex().unlock();
    }
}
