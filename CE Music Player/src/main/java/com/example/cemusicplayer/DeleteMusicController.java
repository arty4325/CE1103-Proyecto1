package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.InformationManager.ListInFile;
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

/**
 * Controlador de la pantalla que permite borrar canciones de las listas de reproduccion
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class DeleteMusicController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private ComboBox<String> Playlist;

    @FXML
    private ComboBox<String> Song;

    /**
     * Lee el arhcivo de texto que contiene el registro de las listas de reproduccion y lo carga en el combo box
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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

    /**
     * Permite borrar el nombre de la cancion de un archivo .txt
     * @param event
     * @throws FileNotFoundException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556 Karthik Balakrishnan https://stackoverflow.com/questions/13729625/overwriting-txt-file-in-java
     */
    @FXML
    void DeleteSong(ActionEvent event) throws FileNotFoundException {
        File FileToBeDeletedMP3 = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/" + Song.getSelectionModel().getSelectedItem());
        File FileToBeDeletedXML = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/" + Song.getSelectionModel().getSelectedItem() + ".xml");
        FileToBeDeletedMP3.delete();
        FileToBeDeletedXML.delete();
        LinkedList<String> list = new LinkedList<>();
        list = FileInList.LoadFileOfStringsIntoList(new File("Users/" + SignInController.getEmail() + "/" + Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt"));
        int Number;
        Number = list.IndexOfItem(Song.getSelectionModel().getSelectedItem());
        list.delete(Number);
        ListInFile.CreateFileWithListInfo(list, "Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt");
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
