package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Controlador de la pantalla que crear nuevas playlist
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class CreatePlaylistController {

    private static DCLinkedList<String> LoadedPlaylist;
    private Stage stage;
    private Scene scene;
    private Parent root;

    static LocalTime localTime;
    static LocalDate localDate;

    @FXML
    private TextField NameOfEntry;

    private static String NameOfPlaylist;

    /**
     * Metodo para obtener el nombre de la playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */

    public static String getNameOfPlaylist() {
        return NameOfPlaylist;

    }

    /**
     * Metodo para obtener la hora de la creacion de la playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String getTime() {
        return String.valueOf(localTime);

    }

    /**
     * Metodo para obtener la fecha de la creacion de la playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String getDate() {
        return String.valueOf(localDate);
    }

    /**
     * Metodo que crea una carpeta de archivo que es la playlist y guarda el nombre de la playlist en txt de playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void CreatePlaylist(ActionEvent event) throws IOException {
        NameOfPlaylist = NameOfEntry.getText();
        System.out.println(NameOfPlaylist);
        String Email = SignInController.getEmail();
        File Dir = new File("Users/" + Email + "/" + NameOfPlaylist);
        localTime = LocalTime.now();//Se llama a una clase de java para obtener la hora de la computadora
        localDate = LocalDate.now();//Se llama a una clase de java para obtener la fecha de la computadora




        //Se revisa si el archivo existe
        if(!Dir.exists()){
            Dir.mkdirs();
            File ExistingPlaylists = new File("Users/" + Email + "/ExistingPlaylist.txt");
            FileWriter PlaylistFileWriter = new FileWriter(ExistingPlaylists, true);
            BufferedWriter Playlistbw = new BufferedWriter(PlaylistFileWriter);
            Playlistbw.write(NameOfPlaylist);
            Playlistbw.newLine();
            Playlistbw.close();
            PlaylistFileWriter.close();
        }


    }
    /**
     * Metodo guardar la fecha y hora de creacion de la playlist en un txt
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */

    public static void SaveDate() throws IOException {
        String time;
        String Email = SignInController.getEmail();//Se obtiene el email que el usuario ingreso en la pantalla de iniciar sesion
        File dateTime = new File("Users/" + Email + "/" + getNameOfPlaylist() + "/DateTime.txt");

        time= String.valueOf(localTime);
        String parts = time.substring(0,8);//Se parte el string para solo colocar en el txt la hora con minutos y segundos

        FileWriter LoadedSongsFileWriter = new FileWriter(dateTime, true);

        BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);
        Songsbw.write(String.valueOf(localDate));
        Songsbw.newLine();
        Songsbw.write(parts);
        Songsbw.newLine();
        Songsbw.close();
        LoadedSongsFileWriter.close();
    }


    /**
     * Metodo para regresar a la pantalla de reproduccion de musica
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */

    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        if (getNameOfPlaylist() !=null){
            SaveDate();
            Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

}
