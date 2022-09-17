package com.example.cemusicplayer.InformationManager;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.DataStructures.DoublyLinkedList;
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
    public static DoublyLinkedList<String> LoadFileOfStringsIntoDoublyLinkedList(File file) throws FileNotFoundException {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        return list;
    }
    public static DCLinkedList<String> LoadFileOfStringsIntoDCLinkedList(File file) throws FileNotFoundException {
        DCLinkedList<String> list = new DCLinkedList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        return list;
    }
}
