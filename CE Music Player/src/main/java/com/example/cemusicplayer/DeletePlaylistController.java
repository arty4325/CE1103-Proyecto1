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

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DeletePlaylistController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ComboBox<String> Playlist;

    private String ChoosedPlaylist;

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
        String selected = Playlist.getSelectionModel().getSelectedItem();
        ChoosedPlaylist = selected;

    }
    @FXML
    void Delete(ActionEvent event) throws IOException {

        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/ExistingPlaylist.txt");

        File FileToBeDeletedMP3 = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem());
        System.out.println(FileToBeDeletedMP3);
        FileToBeDeletedMP3.delete();


        LinkedList<String> list = new LinkedList<>();
        list = FileInList.LoadFileOfStringsIntoList(new File("Users/" + SignInController.getEmail() + "/ExistingPlaylist.txt"));





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

