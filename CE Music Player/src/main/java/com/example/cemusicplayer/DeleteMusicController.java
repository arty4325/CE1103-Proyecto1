package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteMusicController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private ComboBox<String> Playlist;

    @FXML
    private ComboBox<String> Song;

    @FXML
    void ChoosePlaylist(ActionEvent event) {
        System.out.println(Playlist.getSelectionModel().getSelectedItem());
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
    void ChooseSong(ActionEvent event) {

    }

    @FXML
    void DeleteSong(ActionEvent event) throws FileNotFoundException {
        System.out.println(Playlist.getSelectionModel().getSelectedItem());
        System.out.println(Song.getSelectionModel().getSelectedItem());
        File FileToBeDeletedMP3 = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/" + Song.getSelectionModel().getSelectedItem());
        File FileToBeDeletedXML = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/" + Song.getSelectionModel().getSelectedItem() + ".xml");
        FileToBeDeletedMP3.delete();
        FileToBeDeletedXML.delete();
        LinkedList<String> list = new LinkedList<>();
        list = FileInList.LoadFileOfStringsIntoList(new File("Users/" + SignInController.getEmail() + "/" + Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt"));

        System.out.println("Before Deleting");
        System.out.println(Song.getSelectionModel().getSelectedItem());

        int Number;
        Number = list.IndexOfItem(Song.getSelectionModel().getSelectedItem());
        System.out.println(Number);


        //System.out.println(list.getNext());
        //System.out.println(list.getNext());
        //System.out.println(list.getNext());
        //System.out.println(list.getNext());
        //System.out.println(list.getNext());
        //System.out.println(list.getNext());
    }

    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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