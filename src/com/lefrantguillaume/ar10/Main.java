package com.lefrantguillaume.ar10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    private Controller controller = new Controller();
    private Stage primaryStage;

    @Override
    public void start(Stage ps) throws Exception {

        /* FUNCTIONAL */

        this.controller.getComponentsController().getSaveButton().setOnAction(event -> {
            this.controller.saveFile();
        });

        final FileChooser fileChooser = new FileChooser();
        this.controller.getComponentsController().getOpenButton().setOnAction(event -> {
            File file = fileChooser.showOpenDialog(this.primaryStage);
            if (file != null) {
                this.controller.loadFile(file);
            }
        });

        /* SCENE */

        this.primaryStage = ps;
        BorderPane root = new BorderPane();
        root.setCenter(this.createCenter());
        root.setTop(this.createTop());
        root.setPadding(new Insets(7));
        Scene scene = new Scene(root);
        // TODO manage resize. Allow only horizontal.
        // TODO Increase original window width
        this.primaryStage.setTitle("Osu! MakeIt AR10");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private StackPane createTop() {
        VBox top = new VBox(
                new StackPane(controller.getComponentsController().getLabelName()),
                new StackPane(controller.getComponentsController().getLabelStats()),
                new StackPane(controller.getComponentsController().getOpenButton())
        );

        top.setSpacing(7);
        top.setPadding(new Insets(0, 0, 7, 0));
        return new StackPane(top);
    }

    private StackPane createCenter() {
        Label labelCS = new Label("CS");
        Label labelAR = new Label("AR");
        Label labelOD = new Label("OD");
        Label labelHP = new Label("HP");

        GridPane center = new GridPane();

        center.setHgap(7);
        center.setVgap(7);

        center.add(labelCS, 0, 0);
        center.add(labelAR, 0, 1);
        center.add(labelOD, 0, 2);
        center.add(labelHP, 0, 3);

        center.add(controller.getComponentsController().getTextFieldCS(), 1, 0);
        GridPane.setHgrow(controller.getComponentsController().getTextFieldCS(), Priority.ALWAYS);
        center.add(controller.getComponentsController().getTextFieldAR(), 1, 1);
        GridPane.setHgrow(controller.getComponentsController().getTextFieldAR(), Priority.ALWAYS);
        center.add(controller.getComponentsController().getTextFieldOD(), 1, 2);
        GridPane.setHgrow(controller.getComponentsController().getTextFieldOD(), Priority.ALWAYS);
        center.add(controller.getComponentsController().getTextFieldHP(), 1, 3);
        GridPane.setHgrow(controller.getComponentsController().getTextFieldHP(), Priority.ALWAYS);

        center.add(new StackPane(controller.getComponentsController().getSaveButton()), 0, 4, 2, 1);
        center.setPadding(new Insets(7, 0, 0, 0));
        center.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1, 0, 0, 0))));
        return new StackPane(center);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
