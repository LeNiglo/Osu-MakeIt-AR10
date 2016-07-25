package com.lefrantguillaume.ar10;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Guillaume on 25/07/2016.
 */
public class ComponentsController {

    private final Label labelName;
    private final Label labelStats;

    private final TextField textFieldCS;
    private final TextField textFieldAR;
    private final TextField textFieldOD;
    private final TextField textFieldHP;

    private final Button openButton;
    private final Button saveButton;

    public ComponentsController() {
        labelName = new Label("");
        labelStats = new Label("");

        textFieldCS = new TextField();
        textFieldAR = new TextField();
        textFieldOD = new TextField();
        textFieldHP = new TextField();

        openButton = new Button("OPEN");
        saveButton = new Button("SAVE");
    }

    public Label getLabelName() {
        return labelName;
    }

    public Label getLabelStats() {
        return labelStats;
    }

    public TextField getTextFieldCS() {
        return textFieldCS;
    }

    public TextField getTextFieldAR() {
        return textFieldAR;
    }

    public TextField getTextFieldOD() {
        return textFieldOD;
    }

    public TextField getTextFieldHP() {
        return textFieldHP;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getOpenButton() {
        return openButton;
    }
}
