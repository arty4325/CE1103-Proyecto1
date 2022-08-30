package com.example.cemusicplayer;

import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.DataStructures.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("CEMusicPlayer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

}