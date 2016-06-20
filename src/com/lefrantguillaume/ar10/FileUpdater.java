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

    public boolean process() {

        try {
            bReader = getBReader();
            bWriter = getBWriter();
            String line;

            while ((line = bReader.readLine()) != null) { processLine(line); }

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

    private String getNewFilename() {
        String fileName = file.getName();
        int pos = fileName.lastIndexOf("]");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        return file.getParent() + "/" + fileName + " made AR10" + "].osu";
    }

    private void processLine(String line) {
        if (line.startsWith("Version:")) {
            writeToFile(line + " made AR10");
        } else if (line.startsWith("ApproachRate:")) {
            writeToFile("ApproachRate:10");
        } else {
            writeToFile(line);
        }
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

    private BufferedReader getBReader() throws FileNotFoundException {
        InputStream fis = new FileInputStream(file.getAbsolutePath());
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        return new BufferedReader(isr);
    }

    private BufferedWriter getBWriter() throws IOException {
        FileWriter fw = new FileWriter(getNewFilename());
        return new BufferedWriter(fw);
    }
}
