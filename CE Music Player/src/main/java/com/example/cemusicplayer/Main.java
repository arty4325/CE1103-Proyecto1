package com.example.cemusicplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 608, 408);

        stage.setTitle("CEMusicPlayer");

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        //Arduino arduino = new Arduino();
        //arduino.start();
    }

    public static void main(String[] args){
        launch();
    }

}