package com.example.cemusicplayer.InformationManager;

import com.example.cemusicplayer.DataStructures.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInList {
    public static LinkedList<String> LoadFileOfStringsIntoList(File file) throws FileNotFoundException {
        LinkedList<String> list = new LinkedList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        return list;
    }
}