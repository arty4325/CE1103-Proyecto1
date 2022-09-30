package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador que permite editar la metadata de una cancion
 */
public class EditMetadata implements Initializable {

    private Stage stage;
    private Scene scene;


    @FXML
    private ComboBox<String> Playlist;

    @FXML
    private ComboBox<String> Song;



    @FXML
    private TextField Genero;
    @FXML
    private TextField Artista;
    @FXML
    private TextField Album;
    @FXML
    private TextField Year;
    @FXML
    private TextField Letra;


    private String NameOfSong;
    public static String genero;
    public static String artista;
    public static String album;
    public static String year;
    public static String letra;

    private String NameOfPlaylist;

    private String ChoosedSong;
    private String ChoosedPlaylist;

    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Toma la informacin dada en los text fields y intancia XMLController para sobrescribirla en el archivo xml
     * @param event
     * @throws IOException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void Save(ActionEvent event) throws IOException {
        genero= Genero.getText();
        artista=Artista.getText();
        album=Album.getText();
        year=Year.getText();
        letra=Letra.getText();
        XMLController.creator(NameOfSong,genero,artista,album,year,letra,"Users/" + SignInController.getEmail() + "/" + ChoosedPlaylist + "/" + ChoosedSong+".xml");;
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
