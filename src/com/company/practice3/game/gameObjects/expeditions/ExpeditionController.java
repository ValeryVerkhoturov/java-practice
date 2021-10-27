package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.creatures.CharacterController;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gui.ASCIIart;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ExpeditionController implements Runnable{

    private final Field field;

    private final Character character;

    private final Label fieldLbl;

    private final Label equipmentLbl;

    private final Button expeditionBtn;

    private final Button autoExpeditionBtn;

    private final ReentrantLock lock;

    public ExpeditionController(Field field, Character character, ArrayList<Mob> mobs, Label fieldLbl, Label equipmentLbl, Button expeditionBtn, Button autoExpeditionBtn, ReentrantLock lock) {
        this.field = field;
        this.character = character;
        this.field.insertRandomly(character);
        this.field.insertRandomly(mobs);
        this.fieldLbl = fieldLbl;
        this.equipmentLbl = equipmentLbl;
        this.expeditionBtn = expeditionBtn;
        this.autoExpeditionBtn = autoExpeditionBtn;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        Platform.runLater(() -> expeditionBtn.setDisable(true));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(true));
        Platform.runLater(() -> fieldLbl.setText(field.toString()));
        Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        try {
            Thread characterThread = new Thread(new CharacterController(character, field));
            characterThread.setName("Персонаж");
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
