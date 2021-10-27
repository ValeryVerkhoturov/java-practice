package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameLogic.FightLogic;
import com.company.practice3.game.gameObjects.Factory;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gui.ASCIIart;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AutoExpeditionController implements Runnable{

    private final Character character;

    private final Label fieldLbl;

    private final Label equipmentLbl;

    private final Button expeditionBtn;

    private final Button autoExpeditionBtn;

    private final ReentrantLock lock;

    public AutoExpeditionController(Character character, Label fieldLbl, Label equipmentLbl, Button expeditionBtn, Button autoExpeditionBtn, ReentrantLock lock){
        this.character = character;
        this.fieldLbl = fieldLbl;
        this.equipmentLbl = equipmentLbl;
        this.expeditionBtn = expeditionBtn;
        this.autoExpeditionBtn = autoExpeditionBtn;
        this.lock = lock;
    }

    @Override
    public void run() {
        if (!character.isAlive())
            return;
        lock.lock();
        Platform.runLater(() -> expeditionBtn.setDisable(true));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(true));
        Platform.runLater(() -> fieldLbl.setText(ASCIIart.autoExpedition));
        Mob mob = Factory.newRandomMob();
        character.takeDamage(mob.getAtk());
        FightLogic.lootMob(character, mob);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        Platform.runLater(() -> expeditionBtn.setDisable(false));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(false));
        lock.unlock();
    }
}
