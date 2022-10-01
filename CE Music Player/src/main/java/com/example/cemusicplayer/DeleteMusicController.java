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
 * Controlador de la pantalla para eliminar una cancion de una playlist
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
     * Metodo para mostrar las canciones de una playlist en un comboBox
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void ChoosePlaylist(ActionEvent event) {
        System.out.println(Playlist.getSelectionModel().getSelectedItem());
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

    @FXML
    void ChooseSong(ActionEvent event) {

    }
    /**
     * Metodo para eliminar el archivo mp3 y junto con su archivo xml y eliminar el nombre del archivo en el txt de canciones de cada playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void DeleteSong(ActionEvent event) throws FileNotFoundException {
        System.out.println(Playlist.getSelectionModel().getSelectedItem());
        System.out.println(Song.getSelectionModel().getSelectedItem());
        File FileToBeDeletedMP3 = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/" + Song.getSelectionModel().getSelectedItem());
        File FileToBeDeletedXML = new File("Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/" + Song.getSelectionModel().getSelectedItem() + ".xml");
        FileToBeDeletedMP3.delete();//Se elimina el archivo mp3
        FileToBeDeletedXML.delete();//Se elimina el archivo xml de la cancion
        LinkedList<String> list = new LinkedList<>();
        list = FileInList.LoadFileOfStringsIntoList(new File("Users/" + SignInController.getEmail() + "/" + Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt"));


        System.out.println("Before Deleting");
        System.out.println(Song.getSelectionModel().getSelectedItem());

        int Number;
        Number = list.IndexOfItem(Song.getSelectionModel().getSelectedItem());//se obtiene el indice de la cancion en la lista
        System.out.println(Number);

        list.delete(Number);//Se elimina el índice de la cancion
        System.out.println(list.getSize());
        System.out.println("Algo443" + list.get(list.getSize() - 1));


        ListInFile.CreateFileWithListInfo(list, "Users/" + SignInController.getEmail() + "/"+ Playlist.getSelectionModel().getSelectedItem() + "/LoadedSongs.txt");//se actualiza el archivo loadedSongs sin el nombnre de la cancion eliminada
    }
    /**
     * Metodo para regresar a la pantalla de reproduccion de música
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
