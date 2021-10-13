package com.company.practice3.game.gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameApp extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("Application inits");
        super.init();
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameApp.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
//        stage.setTitle("Practice 3 game");
        stage.show();
    }
    @Override
    public void stop() throws Exception {

        System.out.println("Application stops");
        super.stop();
    }
}
