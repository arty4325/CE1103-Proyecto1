package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Controlador de la pantalla que permite crear listas de reproduccion
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class CreatePlaylistController {

    private static DCLinkedList<String> LoadedPlaylist;
    private Stage stage;
    private Scene scene;
    private Parent root;

    static LocalTime localTime;
    static LocalDate localDate;

    @FXML
    private TextField NameOfEntry;

    private static String NameOfPlaylist;

    public static String getNameOfPlaylist() {
        return NameOfPlaylist;

    }

    public static String getTime() {
        return String.valueOf(localTime);

    }

    public static String getDate() {
        return String.valueOf(localDate);
    }

    /**
     * Permite la creacion de listas de reproduccion, crea una carpeta que contendra todos los archivos de la lista
     * @throws IOException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void CreatePlaylist(ActionEvent event) throws IOException {
        NameOfPlaylist = NameOfEntry.getText();
        System.out.println(NameOfPlaylist);
        String Email = SignInController.getEmail();
        File Dir = new File("Users/" + Email + "/" + NameOfPlaylist);
        localTime = LocalTime.now();
        localDate = LocalDate.now();
        if(!Dir.exists()){
            Dir.mkdirs();
            File ExistingPlaylists = new File("Users/" + Email + "/ExistingPlaylist.txt");
            FileWriter PlaylistFileWriter = new FileWriter(ExistingPlaylists, true);
            BufferedWriter Playlistbw = new BufferedWriter(PlaylistFileWriter);
            Playlistbw.write(NameOfPlaylist);
            Playlistbw.newLine();
            Playlistbw.close();
            PlaylistFileWriter.close();
        }
    }

    /**
     * Permite guardar la fecha en la cual fue creada la lista de reproduccion para desplegarla en la pantalla
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     * @throws IOException
     */
    public static void SaveDate() throws IOException {
        String time;
        String Email = SignInController.getEmail();
        File dateTime = new File("Users/" + Email + "/" + getNameOfPlaylist() + "/DateTime.txt");

        time= String.valueOf(localTime);
        String parts = time.substring(0,8);

        FileWriter LoadedSongsFileWriter = new FileWriter(dateTime, true);

        BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);
        Songsbw.write(String.valueOf(localDate));
        Songsbw.newLine();
        Songsbw.write(parts);
        Songsbw.newLine();
        Songsbw.close();
        LoadedSongsFileWriter.close();
    }







    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        if (getNameOfPlaylist() !=null){
            SaveDate();
            Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        }

}

