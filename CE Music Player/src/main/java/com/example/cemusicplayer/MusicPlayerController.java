package com.example.cemusicplayer;

import jaco.mp3.player.MP3Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MusicPlayerController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    MP3Player player;
    File song=new File("MP3\\Slipknot - Snuff  Español.mp3");

    @FXML
    void LSongs(ActionEvent event) throws IOException {
        //String Email = SignInController.getEmail();
        //FileLoader.SongLoader(Email);
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlaylist.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void AddMusic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddMusicMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void play() {

        player=new MP3Player();
        player.addToPlayList(song);
        player.play();
    }

    public void Pause(){
        player.pause();
    }
    public void playAgain(){
        player.play();
    }
}
