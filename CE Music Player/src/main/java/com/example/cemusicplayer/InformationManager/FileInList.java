package com.example.cemusicplayer.InformationManager;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.DataStructures.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInList {

    /**
     * Permite cargar un archivo del computador en una lista simplemente enlazada
     * @param file El archivo del computador que se quiere cargar en la lista
     * @return Una lista simplemente enlazada la cual contiene los elementos del archivo ingresado
     * @throws FileNotFoundException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static LinkedList<String> LoadFileOfStringsIntoList(File file) throws FileNotFoundException {
        LinkedList<String> list = new LinkedList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        return list;
    }
    /**
     * Permite cargar un archivo del computador en una lista doblemente enlazada circular
     * @param file El archivo del computador que se quiere cargar en la lista
     * @return Una lista simplemente enlazada la cual contiene los elementos del archivo ingresado
     * @throws FileNotFoundException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static DCLinkedList<String> LoadFileOfStringsIntoDCLinkedList(File file) throws FileNotFoundException {
        DCLinkedList<String> list = new DCLinkedList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){

            list.add(scan.nextLine());

        }
        return list;
    }


}
