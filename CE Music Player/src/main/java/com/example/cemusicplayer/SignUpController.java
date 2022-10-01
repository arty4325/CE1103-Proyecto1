package com.example.cemusicplayer;

import com.example.cemusicplayer.UserManager.SignUpUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controlador de la pantalla para el registarse
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button UserLoader;
    @FXML
    private ComboBox<String> Provincias;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField UserName;

    private String NameOfPlaylist;

    String Email;
    String Password;
    String Username;
    String Province;

    /**
     * Metodo para obtener el texto que escribio el usuario y guardarlo para crear una carpeta de archivo donde se guardara todo lo del usurio
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    public void LoadTheUser(MouseEvent event) throws IOException {
        Email = email.getText();
        Password = password.getText();
        Username = UserName.getText();
        SignUpUser.CreateUserFolder(Email, Username, Province, Password);


    }
    /**
     * Metodo para regresar a la pantalla de login
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */

    public void Login(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    /**
     * Metodo para dectectar cual la provincia seleccionada por el usuario
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void SelectProvince(ActionEvent event) {
        String selected = Provincias.getSelectionModel().getSelectedItem().toString();
        Province = selected;
    }

    /**
     * Metodo para mostrar las provincias en un comboBox
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("San Jose", "Cartago", "Alajuela", "Heredia", "Puntarenas", "Guanacaste", "Limon");
        Provincias.setItems(list);
    }
}
