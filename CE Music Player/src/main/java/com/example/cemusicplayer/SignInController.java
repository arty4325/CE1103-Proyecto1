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
 * Controlador de la pantalla de inicio de sesion
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

    /**
     * Metodo para obtener el email del usuario
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String getEmail() {
        return Email;
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
     * Metodo para verificacion del email y contrasena del usuario
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void SignInPlatfom(MouseEvent event) throws IOException {
        Email = EmailEntry.getText();
        Password = PasswordEntry.getText();
        Passwords = passwordsEntry.getText();
        File Dir = new File("Users/" + Email);
        if (Dir.exists()){
            // Se revisa el archivo .txt que esta dentro del directorio
            File InfoFile = new File("Users/" + Email + "/UserInformation.txt");
            LinkedList<String> AccoutInformation = new LinkedList<>();
            AccoutInformation = FileInList.LoadFileOfStringsIntoList(InfoFile);
            System.out.println(AccoutInformation.get(3));
            //System.out.println(Password);
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
    /**
     * Metodo para poder ver la contrasena que escribio el usuario en pantalla
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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
