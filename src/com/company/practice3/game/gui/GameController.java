package com.company.practice3.game.gui;

import com.company.practice3.game.gameObjects.Factory;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.expeditions.AutoExpeditionController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameController {
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
        battleField.setText(ASCIIart.base);
        character = Factory.newDefaultCharacter();
        equipment.setText(character.printStats());
    }
    @FXML
    private void runExpedition() throws Exception {
        Thread thread = new Thread(
                Factory.newRandomExpeditionController(
                        character, battleField, equipment, expedition, autoExpedition));
        thread.setName("Экспедиция");
        thread.start();
    }
    @FXML
    private void runAutoExpedition(){
        Thread thread = new Thread(
                new AutoExpeditionController(
                        character, battleField, equipment, expedition, autoExpedition));
        thread.setName("Автоэкспедиция");
        thread.start();
    }
}
