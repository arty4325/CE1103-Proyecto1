package com.example.cemusicplayer.InformationManager;

import javafx.stage.FileChooser;

import java.io.*;

public class FileLoader {
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    public static void SongLoader(String Email) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        File UserFile = new File("Users/" + Email + selectedFile.getName());
        copyFileUsingStream(selectedFile, UserFile);
    }
}
