package com.example.cemusicplayer.InformationManager;

import com.example.cemusicplayer.DataStructures.LinkedList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListInFile {

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

            //while(list.getNext2() != null){
            //    Songsbw.write((String) list.getNext2());
            //    System.out.println(list.getNext2() + "Esta iteracion");
            //    Songsbw.newLine();
            //}
            Songsbw.close();
            SongsWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
