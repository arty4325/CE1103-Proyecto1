package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.InformationManager.FileLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFavoriteController implements Initializable {
    private Stage stage;
    private Scene scene;

    private String ChoosedSong;
    private String ChoosedPlaylist;

    @FXML
    private ComboBox<String> Playlist;

    @FXML
    private ComboBox<String> Song;

    private String NameOfSong;

    private String NameOfPlaylist;

    private String DestPLaylist;



    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PlaylistChooser(ActionEvent event) {
        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt");
        LinkedList<String> list = new LinkedList<>();
        try {
            list = FileInList.LoadFileOfStringsIntoList(ExistingPlaylist);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (list.getSize() > 0){
            for(int i = 0; i < list.getSize(); i++){
                Song.getItems().add(list.getNext());
            }
        }

    }

    @FXML
    void SongChooser(ActionEvent event) {
        ChoosedSong = Song.getSelectionModel().getSelectedItem();
        ChoosedPlaylist = Playlist.getSelectionModel().getSelectedItem();



    }

    @FXML
    void addFavorite(ActionEvent event) throws IOException {
        String Email = SignInController.getEmail();

        NameOfSong = ChoosedSong;

        DestPLaylist=ChoosedPlaylist;
        System.out.println(NameOfSong);


        File LoadedSongs = new File("Users/" + Email + "/" + "/FavoriteSongs.txt");
        FileWriter LoadedSongsFileWriter = new FileWriter(LoadedSongs, true);
        BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);
        Songsbw.write(NameOfSong);
        Songsbw.newLine();
        Songsbw.close();
        LoadedSongsFileWriter.close();


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
