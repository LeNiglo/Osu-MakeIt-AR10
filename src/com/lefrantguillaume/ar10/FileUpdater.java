package com.lefrantguillaume.ar10;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Guillaume on 20/06/2016.
 */
public class FileUpdater {

    final File file;
    BufferedReader bReader = null;
    BufferedWriter bWriter = null;

    public FileUpdater(final File f) {
        file = f;
    }

    /* LOAD MAP FROM FILE */

    public Map loadMap() {
        Map map = new Map();

        try {
            bReader = getBReader();
            String line;

            while ((line = bReader.readLine()) != null) {
                getInfo(line, map);
            }

            bReader.close();
            bReader = null;
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void getInfo(String line, Map map) {
        if (line.startsWith("Title:")) {
            map.setName(line.substring(line.lastIndexOf(":") + 1));
        } else if (line.startsWith("Version:")) {
            map.setVersion(line.substring(line.lastIndexOf(":") + 1));
        } else if (line.startsWith("HPDrainRate:")) {
            map.setHpDrainRate(Integer.parseInt(line.substring(line.lastIndexOf(":") + 1)));
        } else if (line.startsWith("CircleSize:")) {
            map.setCircleSize(Integer.parseInt(line.substring(line.lastIndexOf(":") + 1)));
        } else if (line.startsWith("OverallDifficulty:")) {
            map.setOverallDifficulty(Integer.parseInt(line.substring(line.lastIndexOf(":") + 1)));
        } else if (line.startsWith("ApproachRate:")) {
            map.setApproachRate(Integer.parseInt(line.substring(line.lastIndexOf(":") + 1)));
        }

    }

    /* WRITE MAP TO FILE */

    public boolean saveMap(Map map) {
        try {
            bReader = getBReader();
            bWriter = getBWriter();
            String line;

            while ((line = bReader.readLine()) != null) {
                processLine(line, map);
            }

            bWriter.close();
            bWriter = null;
            bReader.close();
            bReader = null;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void processLine(String line, Map map) {
        if (line.startsWith("Version:")) {
            writeToFile(line + " made AR10");
        } else if (line.startsWith("HPDrainRate:")) {
            writeToFile("HPDrainRate:" + map.getHpDrainRate());
        } else if (line.startsWith("CircleSize:")) {
            writeToFile("CircleSize:" + map.getCircleSize());
        } else if (line.startsWith("OverallDifficulty:")) {
            writeToFile("OverallDifficulty:" + map.getOverallDifficulty());
        } else if (line.startsWith("ApproachRate:")) {
            writeToFile("ApproachRate:" + map.getApproachRate());
        } else {
            writeToFile(line);
        }
    }

    /* HELPERS */

    private BufferedReader getBReader() throws FileNotFoundException {
        InputStream fis = new FileInputStream(file.getAbsolutePath());
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        return new BufferedReader(isr);
    }

    private BufferedWriter getBWriter() throws IOException {
        FileWriter fw = new FileWriter(getNewFilename());
        return new BufferedWriter(fw);
    }

    private String getNewFilename() {
        String fileName = file.getName();
        int pos = fileName.lastIndexOf("]");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        return file.getParent() + "/" + fileName + " made AR10" + "].osu";
    }

    private void writeToFile(final String s) {
        if (bWriter != null) {
            try {
                bWriter.write(s);
                bWriter.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
