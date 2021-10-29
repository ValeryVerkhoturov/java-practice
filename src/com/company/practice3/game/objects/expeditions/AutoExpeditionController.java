package com.company.practice3.game.objects.expeditions;

import com.company.practice3.game.gui.GameController;
import com.company.practice3.game.logic.FightLogic;
import com.company.practice3.game.objects.Factory;
import com.company.practice3.game.objects.creatures.Character;
import com.company.practice3.game.objects.creatures.Mob;
import com.company.practice3.game.gui.AsciiArt;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Value;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Value
public class AutoExpeditionController implements Runnable{

    GameController gameController;

    @Override
    public void run() {
        if (!gameController.getCharacter().isAlive())
            return;
        gameController.getMutex().lock();
        Platform.runLater(() -> gameController.getExpedition().setDisable(true));
        Platform.runLater(() -> gameController.getAutoExpedition().setDisable(true));
        Platform.runLater(() -> gameController.getBattleField().setText(AsciiArt.autoExpedition));
        ArrayList<Mob> mobs = Factory.newRandomMobs();
        for(Mob mob: mobs) {
            FightLogic.autoFight(gameController.getCharacter(), mob);
            if (!gameController.getCharacter().isAlive()) break;
            gameController.getCharacter().castHealSpell();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> gameController.getEquipment().setText(gameController.getCharacter().printStats()));
        Platform.runLater(() -> gameController.getExpedition().setDisable(false));
        Platform.runLater(() -> gameController.getAutoExpedition().setDisable(false));
        gameController.getMutex().unlock();
    }
}
