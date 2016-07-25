package com.lefrantguillaume.ar10;

import java.io.File;

public class Controller {

    private final ComponentsController componentsController = new ComponentsController();
    private Map loadedMap;
    private File loadedFile;

    public void loadFile(File file) {
        try {
            this.loadedFile = file;

            if (this.loadedFile.getName().endsWith(".osu")) {
                FileUpdater updater = new FileUpdater(this.loadedFile);
                // FILE -> MAP
                this.loadedMap = updater.loadMap();
                // MAP -> FIELDS
                this.updateFields();
            } else {
                System.err.println("The file must be a valid beatmap");
                this.loadedFile = null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateFields() {
        this.componentsController.getLabelName().setText(this.loadedMap.getName() + " " + this.loadedMap.getVersion());
        this.componentsController.getLabelStats().setText(this.loadedMap.getStringStats());
        this.componentsController.getTextFieldCS().setText(String.valueOf(this.loadedMap.getCircleSize()));
        this.componentsController.getTextFieldAR().setText(String.valueOf(this.loadedMap.getApproachRate()));
        this.componentsController.getTextFieldOD().setText(String.valueOf(this.loadedMap.getOverallDifficulty()));
        this.componentsController.getTextFieldHP().setText(String.valueOf(this.loadedMap.getHpDrainRate()));
    }

    public void saveFile() {
        try {
            // FIELDS -> MAP
            this.loadFields();
            // TODO Data Validation
            if (true) {
                FileUpdater updater = new FileUpdater(this.loadedFile);
                // MAP -> FILE
                updater.saveMap(this.loadedMap);
                // TODO add success message
                this.updateFields();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadFields() {
        this.loadedMap.setCircleSize(Integer.parseInt(this.componentsController.getTextFieldCS().getText()));
        this.loadedMap.setApproachRate(Integer.parseInt(this.componentsController.getTextFieldAR().getText()));
        this.loadedMap.setOverallDifficulty(Integer.parseInt(this.componentsController.getTextFieldOD().getText()));
        this.loadedMap.setHpDrainRate(Integer.parseInt(this.componentsController.getTextFieldHP().getText()));
    }

    public ComponentsController getComponentsController() {
        return componentsController;
    }
}
