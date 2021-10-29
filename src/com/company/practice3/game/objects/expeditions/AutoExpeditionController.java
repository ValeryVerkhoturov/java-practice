package com.company.practice3.game.objects.expeditions;

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

    Character character;

    Label fieldLbl;

    Label equipmentLbl;

    Button expeditionBtn;

    Button autoExpeditionBtn;

    ReentrantLock lock;

    @Override
    public void run() {
        if (!character.isAlive())
            return;
        lock.lock();
        Platform.runLater(() -> expeditionBtn.setDisable(true));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(true));
        Platform.runLater(() -> fieldLbl.setText(AsciiArt.autoExpedition));
        ArrayList<Mob> mobs = Factory.newRandomMobs();
        for(Mob mob: mobs) {
            FightLogic.autoFight(character, mob);
            if (!character.isAlive()) break;
            character.castHealSpell();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        Platform.runLater(() -> expeditionBtn.setDisable(false));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(false));
        lock.unlock();
    }
}
