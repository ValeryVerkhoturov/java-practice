package com.company.practice3.game.objects.expeditions;

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

    Character character;

    Label fieldLbl;

    Label equipmentLbl;

    Button expeditionBtn;

    Button autoExpeditionBtn;

    ReentrantLock lock;

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
