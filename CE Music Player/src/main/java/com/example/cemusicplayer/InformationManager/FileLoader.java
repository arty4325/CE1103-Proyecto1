package com.example.cemusicplayer.InformationManager;

import javafx.stage.FileChooser;

import java.io.*;

public class FileLoader {
    /**
     * Permite copiar un archivo del computador en una direccion dada, utilizado para crear las listas de reproduccion
     * @param source El archivo que se esta copiando
     * @param dest El destino del archivo que se quiere copiar
     * @throws IOException
     * @author Pankaj https://www.digitalocean.com/community/tutorials/java-copy-file
     */
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

    /**
     * Funcion que se encarga de instanciar copyFileUsingStream
     * @param Email La direccion de correo del usuario que esta ingresando la cancion
     * @param Playlist La playlist en la que se quiere ingresar la cancion
     * @return El nombre del archivo que se esta ingresando en la playlist
     * @throws IOException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, Pankaj
     */
    public static String SongLoader(String Email, String Playlist) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        File UserFile = new File("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName());
        FileWriter file = new FileWriter("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName(), true);
        copyFileUsingStream(selectedFile, UserFile);
        return selectedFile.getName();
    }
}
