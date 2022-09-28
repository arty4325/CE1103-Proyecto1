package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;


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

