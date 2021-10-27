package com.company.practice3.game.gui;

import com.company.practice3.game.gameObjects.Factory;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.expeditions.AutoExpeditionController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.locks.ReentrantLock;

public class GameController {

    private ReentrantLock mutex;

    private Character character;

    @FXML
    private Label battleField;

    @FXML
    private Label equipment;

    @FXML
    private Button expedition;

    @FXML
    private Button autoExpedition;

    @FXML
    private void initialize(){
        character = Factory.newDefaultCharacter();
        equipment.setText(character.printStats());
        mutex = new ReentrantLock();
        runBaseCoffeAnimation();
    }

    @FXML
    private void runExpedition() throws Exception {
        Thread thread = new Thread(
                Factory.newRandomExpeditionController(
                        character, battleField, equipment, expedition, autoExpedition, mutex));
        thread.setName("Экспедиция");
        thread.start();
    }

    @FXML
    private void runAutoExpedition(){
        Thread thread = new Thread(
                new AutoExpeditionController(
                        character, battleField, equipment, expedition, autoExpedition, mutex));
        thread.setName("Автоэкспедиция");
        thread.start();
    }

    private void runBaseCoffeAnimation(){
        Thread thread = new Thread(new BaseAnimationController(battleField, mutex, character, expedition, autoExpedition));
        thread.setName("Анимация кофе на базе");
        thread.start();
    }
}
