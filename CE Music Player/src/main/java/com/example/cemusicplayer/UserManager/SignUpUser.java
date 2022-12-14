package com.example.cemusicplayer.UserManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase que crea la carpeta de archivos de cada usuario
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class SignUpUser {

    /**
     * Metodo para crea la carpeta de archivos de cada usuario
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static void CreateUserFolder(String Email, String Username, String Province, String Password) throws IOException {
        File Dir = new File("Users/" + Email);
        if(!Dir.exists()){
            Dir.mkdirs();
            File InfoFile = new File("Users/" + Email  + "/UserInformation.txt");
            File Playlist = new File("Users/" + Email  + "/ExistingPlaylist.txt");
            Playlist.createNewFile();
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
