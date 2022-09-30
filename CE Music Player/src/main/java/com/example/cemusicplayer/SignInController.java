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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Controlador de la lista de reproduccion que permite Iniciar Sesion en la plataforma
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
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

    public void Login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo que permite ingresar a la plataforma en caso de que los datos ingresados en los entrys sean correctos
     * @param event
     * @throws IOException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void SignInPlatfom(MouseEvent event) throws IOException {
        Email = EmailEntry.getText();
        Password = PasswordEntry.getText();
        Passwords = passwordsEntry.getText();
        File Dir = new File("Users/" + Email);
        if (Dir.exists()){
            File InfoFile = new File("Users/" + Email + "/UserInformation.txt");
            LinkedList<String> AccoutInformation = new LinkedList<>();
            AccoutInformation = FileInList.LoadFileOfStringsIntoList(InfoFile);
            System.out.println(AccoutInformation.get(3));
            if(Password.equals(AccoutInformation.get(3) )){
                Parent root = root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MusicPlayerWindow.fxml")));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                System.out.println("Contra Correcta");
            }else if(PasswordEntry.getText() == ""){
                if(Passwords.equals(AccoutInformation.get(3) )){
                    Parent root = root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MusicPlayerWindow.fxml")));
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
