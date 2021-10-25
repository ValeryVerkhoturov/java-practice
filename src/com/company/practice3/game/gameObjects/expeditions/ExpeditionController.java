package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.creatures.CharacterController;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;
import com.company.practice3.game.gameObjects.creatures.Character;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ExpeditionController implements Runnable{
    private Field field;
    private Character character;
    private ArrayList<Mob> mobs;
    private Label fieldLbl;
    private Label equipmentLbl;
    private Button expeditionBtn;
    private Button autoExpeditionBtn;


    public ExpeditionController(Field field, Character character, ArrayList<Mob> mobs, Label fieldLbl, Label equipmentLbl, Button expeditionBtn, Button autoExpeditionBtn) {
        this.field = field;
        this.character = character;
        this.mobs = mobs;
        this.field.insertRandomly(character);
        this.field.insertRandomly(mobs);
        this.fieldLbl = fieldLbl;
        this.equipmentLbl = equipmentLbl;
        this.expeditionBtn = expeditionBtn;
        this.autoExpeditionBtn = autoExpeditionBtn;
    }

    @Override
    public void run() {
        Platform.runLater(() -> expeditionBtn.setDisable(true));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(true));
        Platform.runLater(() -> fieldLbl.setText(field.toString()));
        if (character != null) Platform.runLater(() -> equipmentLbl.setText(character.printStats()));
        Platform.runLater(() -> expeditionBtn.setDisable(false));
        Platform.runLater(() -> autoExpeditionBtn.setDisable(false));
//        try {
//            CharacterController characterController = new CharacterController(character, field);
//            Thread characterThread = new Thread(characterController);
//            characterThread.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}