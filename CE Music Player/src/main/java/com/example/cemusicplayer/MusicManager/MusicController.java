package com.example.cemusicplayer.MusicManager;

import com.example.cemusicplayer.InformationManager.FileLoader;
import com.example.cemusicplayer.SignInController;
import jaco.mp3.player.MP3Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;

public class MusicController {
    MP3Player player;
    File song=new File("MP3\\Slipknot - Snuff  Español.mp3");

    @FXML
    void LSongs(ActionEvent event) throws IOException {
        String Email = SignInController.getEmail();
        FileLoader.SongLoader(Email);
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
