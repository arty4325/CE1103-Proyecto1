package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controlador de la pantalla para eliminar una playlist
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class DeletePlaylistController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ComboBox<String> Playlist;

    private String ChoosedPlaylist;

    private DCLinkedList<String> load;
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
        stage.setResizable(true);
        stage.show();
    }
    /**
     * Metodo para detectar la playlist seleccionada
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void PlaylistChooser(ActionEvent event) {
        String selected = Playlist.getSelectionModel().getSelectedItem();
        ChoosedPlaylist = selected;

    }

    /**
     * Metodo para eliminar la carpeta de archivo de la playlist y por ende su contenido y elimina el nombre de la playlist en el txt de playlist existentes de cada usuario
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void Delete(ActionEvent event) throws FileNotFoundException {

        // https://www.programiz.com/java-programming/examples/delete-directory#:~:text=In%20Java%2C%20to%20delete%20a,we%20can%20delete%20the%20directory.&text=In%20the%20above%20example%2C%20we%20have%20used%20the%20for%2Deach,files%20present%20in%20the%20directory.
        if (ChoosedPlaylist != null){
            //System.out.println(ChoosedPlaylist);
            //File FileToBeDeletedMP3 = new File("Users/" + SignInController.getEmail() + "/" + ChoosedPlaylist);
            //System.out.println(FileToBeDeletedMP3);
            //FileToBeDeletedMP3.delete();
            try {
                // create a new file object
                File directory = new File("Users/" + SignInController.getEmail() + "/" + ChoosedPlaylist);

                // list all the files in an array
                File[] files = directory.listFiles();

                // delete each file from the directory
                for(File file : files) {
                    System.out.println(file + " deleted.");
                    file.delete();
                }

                // delete the directory
                if(directory.delete()) {
                    System.out.println("Directory Deleted");
                }
                else {
                    System.out.println("Directory not Found");
                }

            } catch (Exception e) {
                e.getStackTrace();
            }

        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();
        }


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

