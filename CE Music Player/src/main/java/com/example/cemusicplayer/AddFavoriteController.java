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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controlador de la pantalla que registra canciones como favoritas
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */

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


    /**
     * Metodo para regresar a la pantalla de reproduccion de musica
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo para mostrar las canciones de cada playlist en un comboBox
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void PlaylistChooser(ActionEvent event) {
        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt");
        LinkedList<String> list = new LinkedList<>();
        try {
            list = FileInList.LoadFileOfStringsIntoList(ExistingPlaylist);//Se coloca en lista simplemente enlazada el archivo de LoadedSongs
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Se revisa si lista es mayor a 0
        if (list.getSize() > 0){
            //Se agrega el nombre de la canciont mientras i sea menor al largo de la lista
            for(int i = 0; i < list.getSize(); i++){
                Song.getItems().add(list.getNext());//Se obtiene el nombre de la cancion y se agrega a la lista
            }
        }

    }
    /**
     * Metodo para detectar la cancion selecciona desde el comboBox
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void SongChooser(ActionEvent event) {
        ChoosedSong = Song.getSelectionModel().getSelectedItem();
        ChoosedPlaylist = Playlist.getSelectionModel().getSelectedItem();
    }
    /**
     * Metodo para guardar el nombre de la cancion al txt llamado favoriteSongs
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void addFavorite(ActionEvent event) throws IOException {
        String Email = SignInController.getEmail();

        NameOfSong = ChoosedSong;

        DestPLaylist=ChoosedPlaylist;
        System.out.println(NameOfSong);

        if (NameOfSong == null){
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una cancion");
            message.showAndWait();

        }else{
            File LoadedSongs = new File("Users/" + Email + "/" + "/FavoriteSongs.txt");
            FileWriter LoadedSongsFileWriter = new FileWriter(LoadedSongs, true);
            BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);
            Songsbw.write(NameOfSong);
            Songsbw.newLine();
            Songsbw.close();
            LoadedSongsFileWriter.close();

        }



    }

    /**
     * Metodo para mostrar las playlist del usuario en un comboBox
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/ExistingPlaylist.txt");
        LinkedList<String> list = new LinkedList<>();
        try {
            list = FileInList.LoadFileOfStringsIntoList(ExistingPlaylist);//Se coloca en lista simplemente enlazada el archivo de playlist existente
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Se revisa si lista es mayor a 0
        if (list.getSize() > 0){
            //Se agrega el nombre de la playlist mientras i sea menor al largo de la lista
            for(int i = 0; i < list.getSize(); i++){
                Playlist.getItems().add(list.getNext());//Se obtiene el nombre de la playliist y se agrega a la lista
            }
        }
    }
}