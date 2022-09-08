package com.example.cemusicplayer;

import com.example.cemusicplayer.InformationManager.FileLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMusicController {
    @FXML
    private TextField PlaylistName;
    private String NameOfPlaylist;
    @FXML
    void SearchSong(ActionEvent event) throws IOException {
        NameOfPlaylist = PlaylistName.getText();
        String Email = SignInController.getEmail();
        FileLoader.SongLoader(Email, NameOfPlaylist);
    }

}