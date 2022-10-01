package com.example.cemusicplayer.InformationManager;


import com.example.cemusicplayer.DataStructures.LinkedList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase que crea un archivo en una direccion específica
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class ListInFile {
    /**
     * Metodo que crea un archivo en una direccion específica
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static void CreateFileWithListInfo(LinkedList list, String Path){
        try {
            File Songs = new File(Path);
            FileWriter SongsWriter = new FileWriter(Songs, false);
            BufferedWriter Songsbw = new BufferedWriter((SongsWriter));
            //Se crea un buble que se realiza hasta que el índice sea mayor al tamaño de la lista
            for (int i = 0; i < list.getSize(); i++){
                Songsbw.write ((String) list.get(i));//Se escribe en el archivo el dato de la lista en la posicion en la que este
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
