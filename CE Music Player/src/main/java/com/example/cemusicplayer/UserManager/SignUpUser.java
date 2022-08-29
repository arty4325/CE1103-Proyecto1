package com.example.cemusicplayer.UserManager;

import java.io.*;
import java.util.Scanner;

public class SignUpUser {
    public static void CreateUserFolder(String path) throws IOException {
        File Dir = new File("Users/" + path);
        if(!Dir.exists()){
            FileWriter file = new FileWriter("Users/Usernames.txt", true);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(path);
            bw.newLine();
            bw.close();
            file.close();
            Dir.mkdirs();
        }
        else {
            System.out.println("ya existe esa carpeta");
        }


    }
}
