package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.MusicManager.XMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class SignInController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField EmailEntry;

    @FXML
    private PasswordField PasswordEntry;
    @FXML
    private TextField passwordsEntry;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Button UserSignIn;
    public static String Email;
    private String Password;
    private String Passwords;

    public static String getEmail() {
        return Email;
    }

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
        Passwords = passwordsEntry.getText();
        File Dir = new File("Users/" + Email);
        if (Dir.exists()){
            // Se revisa el archivo .txt que esta dentro del directorio
            File InfoFile = new File("Users/" + Email + "/UserInformation.txt");
            LinkedList<String> AccoutInformation = new LinkedList<>();
            AccoutInformation = FileInList.LoadFileOfStringsIntoList(InfoFile);
            if(Password.equals(AccoutInformation.get(3) )){

                Parent root = null;
                XMLController.readxml();

                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MusicPlayerWindow.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                System.out.println("Contra Correcta");
            }else if(PasswordEntry.getText() == ""){
                if(Passwords.equals(AccoutInformation.get(3) )){
                    Parent root = null;

                    try {
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MusicPlayerWindow.fxml")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    System.out.println("Contra Correcta");


                }else {
                    System.out.println("Contra Incorrecta");
                }

            }else {
                System.out.println("Contra Incorrecta");
            }

        }
    }
    public void seePassword(ActionEvent event){
        if (checkBox.isSelected()){
            passwordsEntry.setText(PasswordEntry.getText());
            passwordsEntry.setVisible(true);
            PasswordEntry.setVisible(false);


        }else{
            PasswordEntry.setText(passwordsEntry.getText());
            PasswordEntry.setVisible(true);
            passwordsEntry.setVisible(false);
        }
    }



}
