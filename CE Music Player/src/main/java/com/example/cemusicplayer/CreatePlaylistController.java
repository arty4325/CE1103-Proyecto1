package com.example.cemusicplayer;

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


public class CreatePlaylistController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField NameOfEntry;

    private String NameOfPlaylist;

    @FXML
    void CreatePlaylist(ActionEvent event) throws IOException {
        NameOfPlaylist = NameOfEntry.getText();
        System.out.println(NameOfPlaylist);
        String Email = SignInController.getEmail();
        File Dir = new File("Users/" + Email + "/" + NameOfPlaylist);
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

    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

