package com.example.cemusicplayer.InformationManager;

import com.example.cemusicplayer.DataStructures.LinkedList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListInFile {
    /**
     * Metodo que permite crear un archivo .txt con la informacino contenida en una lista simplemente enlazada
     * @param list La lista de la cual se quiere tomar la informacion que se colocara en el archivo
     * @param Path La direccion del archivo en donde se quiere colocar la informacion
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, Karthik Balakrishnan https://stackoverflow.com/questions/13729625/overwriting-txt-file-in-java
     */
    public static void CreateFileWithListInfo(LinkedList list, String Path){
        try {
            File Songs = new File(Path);
            FileWriter SongsWriter = new FileWriter(Songs, false);
            BufferedWriter Songsbw = new BufferedWriter((SongsWriter));

            for (int i = 0; i < list.getSize(); i++){
                Songsbw.write ((String) list.get(i));
                System.out.println((String) list.get(i));
                Songsbw.newLine();
            }
            Songsbw.close();
            SongsWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
