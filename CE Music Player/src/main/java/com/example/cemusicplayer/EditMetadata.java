package com.example.cemusicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditMetadata {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField Genero;
    @FXML
    private TextField Artista;
    @FXML
    private TextField Album;
    @FXML
    private TextField Year;
    @FXML
    private TextField Letra;

    public static String genero;
    public static String artista;
    public static String album;
    public static String year;
    public static String letra;








    @FXML
    void ReturnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayerWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Save(ActionEvent event) throws IOException {
        genero= Genero.getText();
        artista=Artista.getText();
        album=Album.getText();
        year=Year.getText();
        letra=Letra.getText();
        System.out.println(genero);
        System.out.println(artista);
        System.out.println(album);
        System.out.println(year);
        System.out.println(letra);


    }




}
