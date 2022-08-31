package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractCollection;

public class SignInController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField EmailEntry;

    @FXML
    private TextField PasswordEntry;

    @FXML
    private Button UserSignIn;
    String Email;
    String Password;

    public void Login(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SignInPlatfom(MouseEvent event) throws FileNotFoundException {
        Email = EmailEntry.getText();
        Password = PasswordEntry.getText();
        File Dir = new File("Users/" + Email);
        if (Dir.exists()){
            // Se revisa el archivo .txt que esta dentro del directorio
            File InfoFile = new File("Users/" + Email + "/UserInformation.txt");
            LinkedList<String> AccoutInformation = new LinkedList<>();
            AccoutInformation = FileInList.LoadFileOfStringsIntoList(InfoFile);
            if(Password.equals(AccoutInformation.get(3))){
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Music.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                System.out.println("Contra Correcta");
            } else {
                System.out.println("Contra Incorrecta");
            }
        }
    }
}
