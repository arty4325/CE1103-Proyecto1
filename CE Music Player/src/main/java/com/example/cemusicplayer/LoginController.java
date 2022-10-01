package com.example.cemusicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Controlador de la pantalla que muestras las dos opciones o un boton para iniciar sesion o registrarse
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Metodo para abrir la pantalla de inicio de seccion
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void SignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    /**
     * Metodo para abrir la pantalla de registrarse
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void SignIn(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


}
