package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.DataStructures.DoublyLinkedList;
import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import jaco.mp3.player.MP3Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MusicPlayerController implements Initializable {
    @FXML
    private ComboBox<String> Playlist;

    @FXML
    private Button CircularNext;

    @FXML
    private Button CircularBack;
    @FXML
    private Label music;
    boolean c=true;
    boolean loop=true;

    private Stage stage;
    private Scene scene;
    private Parent root;
    DoublyLinkedList<String> LoadedPlaylist;
    DCLinkedList<String> CircularLoadPLayList;
    String PlayingPlaylist;
    MP3Player player = new MP3Player();
    File song; // = new File("MP3\\Slipknot - Snuff  Español.mp3");
    @FXML
    void LastSong(ActionEvent event) {
        String ChoosedSong = LoadedPlaylist.getBack();
        song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
        player.addToPlayList(song);
        player.skipForward();
        music.setText(ChoosedSong);
        System.out.println(ChoosedSong);
    }

    @FXML
    void NextSong(ActionEvent event) {
        String ChoosedSong = LoadedPlaylist.getNext();
        song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
        player.addToPlayList(song);
        player.skipForward();
        music.setText(ChoosedSong);
        System.out.println(ChoosedSong);
    }

    @FXML
    void LSongs(ActionEvent event) throws IOException {
        //String Email = SignInController.getEmail();
        //FileLoader.SongLoader(Email);
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlaylist.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void AddMusic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddMusicMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void play() {
        System.out.println(PlayingPlaylist);
        player.addToPlayList(song);

        player.play();
    }

    public void Pause(){


        if (c== true){
            player.pause();
            c=false;
        }else{
            player.play();
            c=true;

        }

    }
    public void volumeDown(Double d){
        Mixer.Info [] mixers= AudioSystem.getMixerInfo();
        for(Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfo=mixer.getTargetLineInfo();
            for(Line.Info lineI:lineInfo){
                Line line =null;
                boolean open = true;

                try{
                    line=mixer.getLine(lineI);
                    open=line.isOpen() || line instanceof Clip;
                    if(!open){
                        line.open();
                    }
                    FloatControl controlV = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float current=controlV.getValue();
                    Double volumeC=d;
                    float change=(float) ((float)current-(double)volumeC);
                    controlV.setValue(change);
                } catch (LineUnavailableException lineUnavailableException) {
                }catch (IllegalArgumentException illegalArgumentException){
                }finally {
                    if(line!=null && !open){
                        line.close();
                    }
                }
            }
        }

    }
    public void volumeUp(Double d){
        Mixer.Info [] mixers= AudioSystem.getMixerInfo();
        for(Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfo=mixer.getTargetLineInfo();
            for(Line.Info lineI:lineInfo){
                Line line =null;
                boolean open = true;

                try{
                    line=mixer.getLine(lineI);
                    open=line.isOpen() || line instanceof Clip;
                    if(!open){
                        line.open();
                    }
                    FloatControl controlV = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float current=controlV.getValue();
                    Double volumeC=d;
                    float change=(float) ((float)current+(double)volumeC);
                    controlV.setValue(change);
                } catch (LineUnavailableException lineUnavailableException) {
                }catch (IllegalArgumentException illegalArgumentException){
                }finally {
                    if(line!=null && !open){
                        line.close();
                    }
                }
            }
        }

    }
    public void Up(){
        volumeUp(0.2);
    }
    public void down(){
        volumeDown(0.2);
    }

    @FXML
    void PlaylistChooser(ActionEvent event) throws FileNotFoundException {
        String selected = Playlist.getSelectionModel().getSelectedItem();
        PlayingPlaylist = selected;
        LoadedPlaylist = FileInList.LoadFileOfStringsIntoDoublyLinkedList(new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/LoadedSongs.txt"));
        song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getNext());
    }

    @FXML
    void Loop(ActionEvent event) throws FileNotFoundException {
        if(loop==true){
            player.stop();
            CircularLoadPLayList=FileInList.LoadFileOfStringsIntoDCLinkedList(new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/LoadedSongs.txt"));
            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + CircularLoadPLayList.GetNextPosition());

            System.out.println("hola");
            CircularNext.setVisible(true);
            CircularBack.setVisible(true);
            loop=false;
            System.out.println(loop);


        }else{
            player.stop();

            LoadedPlaylist = FileInList.LoadFileOfStringsIntoDoublyLinkedList(new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/LoadedSongs.txt"));
            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getNext());
            loop=true;
            System.out.println("holas");
            CircularNext.setVisible(false);
            CircularBack.setVisible(false);


        }


    }

    @FXML
    void CircularLastSong(ActionEvent event) {
        String ChoosedSong = CircularLoadPLayList.GetBackPosition();
        song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
        player.addToPlayList(song);
        player.skipForward();
        System.out.println(ChoosedSong);
    }

    @FXML
    void CircularNextSong(ActionEvent event) {
        String ChoosedSong = CircularLoadPLayList.GetNextPosition();
        song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
        player.addToPlayList(song);
        player.skipForward();
        System.out.println(ChoosedSong);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/ExistingPlaylist.txt");
        LinkedList<String> list = new LinkedList<>();
        try {
            list = FileInList.LoadFileOfStringsIntoList(ExistingPlaylist);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (list.getSize() > 0){
            for(int i = 0; i < list.getSize(); i++){
                Playlist.getItems().add(list.getNext());
            }
        }


    }
}
