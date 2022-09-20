package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.InformationManager.FileLoader;
import com.example.cemusicplayer.MusicManager.XMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMusicController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ComboBox<String> Playlist;


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

        NameOfArtist = SongArtist.getText();
        NameOfGenre = SongGenre.getText();
        NameOfLyrics = SongLyrics.getText();
        NameOfYear = SongYear.getText();
        NameOfAlbum = SongAlbum.getText();
        String Email = SignInController.getEmail();
        NameOfSong = FileLoader.SongLoader(Email, NameOfPlaylist);
        System.out.println(NameOfSong);
        File xmlFile = new File("Users/" + Email + "/" + NameOfPlaylist + "/" + NameOfPlaylist + ".xml");

        File LoadedSongs = new File("Users/" + Email + "/" + NameOfPlaylist + "/LoadedSongs.txt");
        FileWriter LoadedSongsFileWriter = new FileWriter(LoadedSongs, true);
        BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);
        Songsbw.write(NameOfSong);
        Songsbw.newLine();
        Songsbw.close();
        LoadedSongsFileWriter.close();


        XMLController.creator(
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
    @FXML
    void ChoosePlaylist(ActionEvent event) {
        String selected = Playlist.getSelectionModel().getSelectedItem();
        NameOfPlaylist = selected;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/ExistingPlaylist.txt");
        LinkedList<String> list = new LinkedList<>();
        try {
            list = FileInList.LoadFileOfStringsIntoList(ExistingPlaylist);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (list.getSize() > 0){
            for(int i = 0; i < list.getSize(); i++){
                Playlist.getItems().add(list.getNext());
            }
        }
    }
}