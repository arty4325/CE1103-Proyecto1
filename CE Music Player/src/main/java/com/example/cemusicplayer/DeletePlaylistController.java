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
 * Controlador que permite borrar listas de reproduccion
 */
public class DeletePlaylistController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ComboBox<String> Playlist;

    private String ChoosedPlaylist;

    private DCLinkedList<String> load;

    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    @FXML
    void PlaylistChooser(ActionEvent event) {
        String selected = Playlist.getSelectionModel().getSelectedItem();
        ChoosedPlaylist = selected;

    }

    /**
     * El metodo permite borrar la carpeta de la playlist, para hacer esto primero hay que vaciar la playlist
     * @throws FileNotFoundException
     * @autho Programiz https://www.programiz.com/java-programming/examples/delete-directory#:~:text=In%20Java%2C%20to%20delete%20a,we%20can%20delete%20the%20directory.&text=In%20the%20above%20example%2C%20we%20have%20used%20the%20for%2Deach,files%20present%20in%20the%20directory.
     */
    @FXML
    void Delete(ActionEvent event) throws FileNotFoundException {
        // https://www.programiz.com/java-programming/examples/delete-directory#:~:text=In%20Java%2C%20to%20delete%20a,we%20can%20delete%20the%20directory.&text=In%20the%20above%20example%2C%20we%20have%20used%20the%20for%2Deach,files%20present%20in%20the%20directory.
        if (ChoosedPlaylist != null){
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

