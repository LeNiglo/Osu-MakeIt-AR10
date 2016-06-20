package com.lefrantguillaume.ar10;

import java.io.File;

public class Controller {

    public void updateFile(File file) {
        try {

            if (file.getName().endsWith(".osu")) {
                FileUpdater updater = new FileUpdater(file);
                updater.process();
            } else {
                System.err.println("The file must be a valid beatmap");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
