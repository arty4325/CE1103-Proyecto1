package com.example.cemusicplayer.InformationManager;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.DataStructures.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Clase para colocar un archivo en una lista
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class FileInList {

    /**
     * Metodo para cargar un archivo en lista simple
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static LinkedList<String> LoadFileOfStringsIntoList(File file) throws FileNotFoundException {
        LinkedList<String> list = new LinkedList<>();
        //Se coloca en el scanner el archivo para leerlo
        Scanner scan = new Scanner(file);
        //Se hace un while para que se lea mientras haya siguiente línea
        while(scan.hasNextLine()){
            list.add(scan.nextLine());//Se agrega a la lista la línea que se leyo del archivo
        }
        return list;
    }
    /**
     * Metodo para cargar un archivo en lista doblemente enlazada circular
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static DCLinkedList<String> LoadFileOfStringsIntoDCLinkedList(File file) throws FileNotFoundException {
        DCLinkedList<String> list = new DCLinkedList<>();
        //Se coloca en el scanner el archivo para leerlo
        Scanner scan = new Scanner(file);
        //Se hace un while para que se lea mientras haya siguiente línea
        while(scan.hasNextLine()){

            list.add(scan.nextLine());//Se agrega a la lista la línea que se leyo del archivo

        }
        return list;
    }


}
