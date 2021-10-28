package com.company.practice3.game.objects.expeditions;

import com.company.practice3.game.logic.FightLogic;
import com.company.practice3.game.objects.creatures.Character;
import com.company.practice3.game.objects.creatures.Mob;
import com.company.practice3.game.gui.AsciiArt;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Data;
import lombok.NonNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class AutoExpeditionController implements Runnable{

    @NonNull private final Character character;

    @NonNull private final Label fieldLbl;

    @NonNull private final Label equipmentLbl;

    @NonNull private final Button expeditionBtn;

    @NonNull private final Button autoExpeditionBtn;

    @NonNull private final ReentrantLock lock;

    @NonNull private final Mob mob;

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
