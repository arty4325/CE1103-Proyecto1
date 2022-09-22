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
    public static String SongLoader(String Email, String Playlist) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        System.out.println(selectedFile);
        File UserFile = new File("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName());
        //File Songs = new File("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName() + ".txt");
        FileWriter file = new FileWriter("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName(), true);
        //BufferedWriter bw = new BufferedWriter(file);
        //bw.write(selectedFile.getName());
        //bw.newLine();
        //bw.close();
        copyFileUsingStream(selectedFile, UserFile);
        return selectedFile.getName();
    }
}
