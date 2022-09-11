package com.example.cemusicplayer;

import com.example.cemusicplayer.InformationManager.FileLoader;
import com.example.cemusicplayer.MusicManager.XMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddMusicController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField PlaylistName;

    @FXML
    private TextField SongAlbum;

    @FXML
    private TextField SongArtist;

    @FXML
    private TextField SongGenre;

    @FXML
    private TextField SongLyrics;

    @FXML
    private TextField SongYear;
    private String NameOfPlaylist;
    private String NameOfSong;
    private String NameOfArtist;
    private String NameOfGenre;
    private String NameOfLyrics;
    private String NameOfYear;
    private String NameOfAlbum;

    @FXML
    void SearchSong(ActionEvent event) throws IOException {
        NameOfPlaylist = PlaylistName.getText();
        NameOfArtist = SongArtist.getText();
        NameOfGenre = SongGenre.getText();
        NameOfLyrics = SongLyrics.getText();
        NameOfYear = SongYear.getText();
        NameOfAlbum = SongAlbum.getText();
        String Email = SignInController.getEmail();
        NameOfSong = FileLoader.SongLoader(Email, NameOfPlaylist);
        System.out.println(NameOfSong);
        File xmlFile = new File("Users/" + Email + "/" + NameOfPlaylist + "/" + NameOfPlaylist + ".xml");


        boolean exists = xmlFile.exists();
        System.out.println(exists);
        XMLController.creator(exists,
                NameOfSong,
                NameOfGenre,
                NameOfArtist,
                NameOfAlbum,
                NameOfYear,
                NameOfLyrics,
                "Users/" + Email + "/" + NameOfPlaylist + "/" + NameOfSong + ".xml");
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