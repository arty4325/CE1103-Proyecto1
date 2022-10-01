package com.example.cemusicplayer.InformationManager;

import javafx.stage.FileChooser;

import java.io.*;
/**
 * Clase para cargar archivos
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class FileLoader {
    /**
     * Metodo para copiar archivos en una ruta especifica
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);//Se agrega al flujo de entrada de archivo el archivo fuente
            os = new FileOutputStream(dest);//Se agrega al flujo de entrada de archivo el archivo de destino
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);//Se escribe en el archivo de destino
            }
        } finally {
            is.close();
            os.close();
        }
    }
    /**
     * Metodo para cargar las canciones en la carpeta de la playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String SongLoader(String Email, String Playlist) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);//Se abre una ventana para que el usuario elija la cancion desde el explorador de archivo
        System.out.println(selectedFile);
        File UserFile = new File("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName());
        FileWriter file = new FileWriter("Users/" + Email + "/" + Playlist + "/" + selectedFile.getName(), true);
        copyFileUsingStream(selectedFile, UserFile);//Se llama al metodo para copiar el archivo de la cancion en la ruta definida
        return selectedFile.getName();
    }
}
