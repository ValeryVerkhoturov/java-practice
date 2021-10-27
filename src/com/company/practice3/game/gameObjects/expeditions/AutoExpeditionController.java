package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameLogic.FightLogic;
import com.company.practice3.game.gameObjects.Factory;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gui.AsciiArt;
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

    private final Mob mob;

    public AutoExpeditionController(Character character, Label fieldLbl, Label equipmentLbl, Button expeditionBtn, Button autoExpeditionBtn, ReentrantLock lock, Mob mob){
        this.character = character;
        this.fieldLbl = fieldLbl;
        this.equipmentLbl = equipmentLbl;
        this.expeditionBtn = expeditionBtn;
        this.autoExpeditionBtn = autoExpeditionBtn;
        this.lock = lock;
        this.mob = mob;
    }

    @Override
    public void run() {
        if (!character.isAlive())
            return;
        lock.lock();
        Platform.runLater(() -> expeditionBtn.setDisable(true));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(true));
        Platform.runLater(() -> fieldLbl.setText(AsciiArt.autoExpedition));
        character.takeDamage(mob.getAtk() * 4);
        character.castHealSpell();
        FightLogic.lootMob(character, mob);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        Platform.runLater(() -> expeditionBtn.setDisable(false));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(false));
        lock.unlock();
    }
}
