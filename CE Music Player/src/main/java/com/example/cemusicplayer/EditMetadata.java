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
 * Controlador de la pantalla editar metadata
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
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
     * Metodo para editar la metadata de la cancion y guardar esos cambios
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
    /**
     * Metodo para mostrar las canciones de una playlist en un comboBox
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
     * Metodo para dectectar la cancion seleccionada
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void SongChooser(ActionEvent event) {
        ChoosedSong = Song.getSelectionModel().getSelectedItem();
        ChoosedPlaylist = Playlist.getSelectionModel().getSelectedItem();



    }

    /**
     * Metodo para mostrar las canciones de cada playlist en un comboBox
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
