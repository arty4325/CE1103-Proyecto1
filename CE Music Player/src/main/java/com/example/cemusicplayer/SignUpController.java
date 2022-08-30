package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    String Email;
    String Password;
    String Username;
    String Province;
    @FXML
    public void LoadTheUser(MouseEvent event) throws IOException {
        Email = email.getText();
        Password = password.getText();
        Username = UserName.getText();
        SignUpUser.CreateUserFolder(Email, Username, Province, Password);

    }
    public void Login(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SelectProvince(ActionEvent event) {
        String selected = Provincias.getSelectionModel().getSelectedItem().toString();
        Province = selected;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("San Jose", "Cartago", "Alajuela", "Heredia", "Puntarenas", "Guanacaste", "Limon");
        Provincias.setItems(list);
    }
}

