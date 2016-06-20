package com.lefrantguillaume.ar10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{

        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open a beatmap");

        openButton.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                controller.updateFile(file);
            }
        });

        StackPane root = new StackPane(openButton);
        primaryStage.setTitle("Osu! MakeIt AR10");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
