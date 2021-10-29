package com.company.practice3.game.gui;

import com.company.practice3.game.objects.Factory;
import com.company.practice3.game.objects.creatures.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameController {

    ReentrantLock mutex;

    Character character;

    @FXML
    Label battleField;

    @FXML
    Label equipment;

    @FXML
    Button expedition;

    @FXML
    Button autoExpedition;

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
                        character, battleField, equipment,
                        expedition, autoExpedition, mutex));
        thread.setName("Экспедиция");
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    private void runAutoExpedition(){
        Thread thread = new Thread(
                Factory.newRandomAutoExpedtionController(
                        character, battleField, equipment,
                        expedition, autoExpedition, mutex));
        thread.setName("Автоэкспедиция");
        thread.setDaemon(true);
        thread.start();
    }

    private void runBaseCoffeAnimation(){
        Thread thread = new Thread(
                new BaseAnimationController(
                        character, battleField,
                        expedition, autoExpedition, mutex));
        thread.setName("Анимация кофе на базе");
        thread.setDaemon(true);
        thread.start();
    }
}
