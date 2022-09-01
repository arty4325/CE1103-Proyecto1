package com.example.cemusicplayer.UserManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpUser {
    public static void CreateUserFolder(String Email, String Username, String Province, String Password) throws IOException {
        File Dir = new File("Users/" + Email);
        if(!Dir.exists()){
            //FileWriter file = new FileWriter("Users/Email.txt", true);
            //BufferedWriter bw = new BufferedWriter(file);
            //bw.write(Email);
            //bw.newLine();
            //bw.close();
            //file.close();
            Dir.mkdirs();
            File InfoFile = new File("Users/" + Email  + "/UserInformation.txt");
            FileWriter InfoFileWriter = new FileWriter(InfoFile, true);
            BufferedWriter InfoFilebw = new BufferedWriter(InfoFileWriter);
            InfoFilebw.write(Email);
            InfoFilebw.newLine();
            InfoFilebw.write(Username);
            InfoFilebw.newLine();
            InfoFilebw.write(Province);
            InfoFilebw.newLine();
            InfoFilebw.write(Password);
            InfoFilebw.newLine();
            InfoFilebw.close();
            InfoFileWriter.close();

        }
        else {
            System.out.println("ya existe esa carpeta");
        }
    }
}
