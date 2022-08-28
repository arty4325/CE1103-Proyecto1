package com.example.cemusicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UserController {

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

}

