package com.example.cemusicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button UserLoader;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField UserName;

    String Email;
    String Password;
    String Username;
    @FXML
    public void LoadTheUser(MouseEvent event) {
        Email = email.getText();
        Password = password.getText();
        Username = UserName.getText();

        System.out.println(Username);
        System.out.println(Password);
        System.out.println(Email);
    }
    public void Login(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

