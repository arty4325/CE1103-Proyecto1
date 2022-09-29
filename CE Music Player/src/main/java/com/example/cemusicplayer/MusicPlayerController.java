package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.MusicManager.XMLController;
import jaco.mp3.player.MP3Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MusicPlayerController implements Initializable {
    @FXML
    private ComboBox<String> Playlist;

    @FXML
    private Button PlayButton;

    @FXML
    private Button LastButton;

    @FXML
    private Button NextButton;

    @FXML
    private Button FavoriteButton;

    @FXML
    private Button PauseButton;

    @FXML
    private Button LoopButton;

    @FXML
    private ImageView fondoFavorito;

    @FXML
    private Label date;

    @FXML
    private Label time;

    @FXML
    private Label label;

    @FXML
    private Label Genero;


    @FXML
    private Label Album;

    @FXML
    private Label Year;

    @FXML
    private Button backButton;
    @FXML
    private Button UpButton;


    @FXML
    private Label Artist;

    @FXML
    private Label Lyrics;
    boolean c = true;
    boolean loop = false;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label num;

    private DCLinkedList<String> LoadedPlaylist;

    private DCLinkedList<String> DateTime;

    boolean F;

    private int size;

    String PlayingPlaylist;
    MP3Player player = new MP3Player();
    File song;
    static String ChoosedSong;
    File Metadata;


    @FXML
    void LastSong(ActionEvent event) throws FileNotFoundException {
        if (loop == false){
            ChoosedSong = LoadedPlaylist.getBackItemNotLoop();
            label.setText(ChoosedSong);
            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
            Metadata= new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong+".xml");
            Genero.setText(XMLController.GetGenero(Metadata));
            Artist.setText(XMLController.GetArtist(Metadata));
            Album.setText(XMLController.GetAlbum(Metadata));
            Year.setText(XMLController.GetYear(Metadata));
            Lyrics.setText(XMLController.GetLyrics(Metadata));
            SearchFavorite(ChoosedSong);

            player.addToPlayList(song);
            player.skipForward();

            System.out.println(ChoosedSong);
        }else if (loop == true){
            String ChoosedSong = LoadedPlaylist.getBackItem();
            label.setText(ChoosedSong);
            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
            Metadata= new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong+".xml");
            Genero.setText(XMLController.GetGenero(Metadata));
            Artist.setText(XMLController.GetArtist(Metadata));
            Album.setText(XMLController.GetAlbum(Metadata));
            Year.setText(XMLController.GetYear(Metadata));
            Lyrics.setText(XMLController.GetLyrics(Metadata));

            SearchFavorite(ChoosedSong);

            player.addToPlayList(song);
            player.skipForward();


            System.out.println(ChoosedSong);
        }
    }

    @FXML
    void NextSong(ActionEvent event) throws FileNotFoundException {
        if (!loop){

            String ChoosedSong = LoadedPlaylist.getNextItemNotLoop();

            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
            Metadata= new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong+".xml");
            Genero.setText(XMLController.GetGenero(Metadata));
            Artist.setText(XMLController.GetArtist(Metadata));
            Album.setText(XMLController.GetAlbum(Metadata));
            Year.setText(XMLController.GetYear(Metadata));
            Lyrics.setText(XMLController.GetLyrics(Metadata));
            SearchFavorite(ChoosedSong);

            player.addToPlayList(song);
            player.skipForward();
            System.out.println(ChoosedSong);
            label.setText(ChoosedSong);
            System.out.println("Loop Song");
        } else if (loop){
            String ChoosedSong = LoadedPlaylist.getNextItem();
            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
            Metadata= new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong+".xml");
            Genero.setText(XMLController.GetGenero(Metadata));
            Artist.setText(XMLController.GetArtist(Metadata));
            Album.setText(XMLController.GetAlbum(Metadata));
            Year.setText(XMLController.GetYear(Metadata));
            Lyrics.setText(XMLController.GetLyrics(Metadata));
            SearchFavorite(ChoosedSong);
            player.addToPlayList(song);
            player.skipForward();
            label.setText(ChoosedSong);
            System.out.println(ChoosedSong);
        }
    }

    @FXML
    void LSongs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlaylist.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void AddMusic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddMusicMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void DeleteMusic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteMusicMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void Edit(ActionEvent event) throws IOException {
        player.stop();
        Parent root = FXMLLoader.load(getClass().getResource("EditMetadata.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
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

    public Void SearchFavorite(String song) throws FileNotFoundException {

        Scanner favorite = new Scanner(song);
        String cancion = favorite.next();
        String email = SignInController.getEmail();
        File file = new File("Users/" + email + "/FavoriteSongs.txt");
        Scanner scanner;


        scanner = new Scanner(file);
        while (scanner.hasNext()) {
            final String lineFromFile = scanner.nextLine();
            if (lineFromFile.contains(cancion)) {
                F=true;
                fondoFavorito.setVisible(F);
                break;

            }else{
                F=false;
                fondoFavorito.setVisible(F);

            }


        }


        return null;
    }

    @FXML
    void AddFavorite(ActionEvent event) throws IOException {
        String Email = SignInController.getEmail();


        System.out.println(label);

        File LoadedSongs = new File("Users/" + Email + "/" + "/FavoriteSongs.txt");
        FileWriter LoadedSongsFileWriter = new FileWriter(LoadedSongs, true);
        BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);

        Songsbw.write(String.valueOf(label));
        Songsbw.newLine();
        Songsbw.close();
        LoadedSongsFileWriter.close();
        SearchFavorite(String.valueOf(label));
    }

        @FXML
    void PlaylistChooser(ActionEvent event) throws FileNotFoundException {
        String selected = Playlist.getSelectionModel().getSelectedItem();
        PlayingPlaylist = selected;
        File play=new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/LoadedSongs.txt");

        DateTime = FileInList.LoadFileOfStringsIntoDCLinkedList(new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/DateTime.txt"));

        date.setText("Fecha: " +Date());
        time.setText("Hora: " + Time());

        if (play.exists()){
            LoadedPlaylist = FileInList.LoadFileOfStringsIntoDCLinkedList(play);
            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getNextItem());
            num.setText("Canciones: " + numSongs());
            size = LoadedPlaylist.getSize();
            PlayButton.setDisable(false);
            LastButton.setDisable(false);
            NextButton.setDisable(false);
            PauseButton.setDisable(false);
            LoopButton.setDisable(false);
            FavoriteButton.setDisable(false);
            UpButton.setDisable(false);
            backButton.setDisable(false);

        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor agregue canciones a su playlist");
            message.showAndWait();
            PlayButton.setDisable(true);
            LastButton.setDisable(true);
            NextButton.setDisable(true);
            PauseButton.setDisable(true);
            LoopButton.setDisable(true);
            FavoriteButton.setDisable(true);

        }

    }

    @FXML
    void Loop(ActionEvent event)  {
        if(loop==false){
            //player.stop();
            System.out.println("pone loop");
            loop = true;
            System.out.println(loop);
        }else{
           // song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getNext());
            loop=false;
            System.out.println("quita loop");
            System.out.println(loop);
        }
    }
    @FXML
    void DeletePlaylist(ActionEvent event) throws IOException {
        player.stop();
        Parent root = FXMLLoader.load(getClass().getResource("DeletePlaylist.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Favorite(ActionEvent event) throws IOException {
        player.stop();
        Parent root = FXMLLoader.load(getClass().getResource("AddFavorite.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public String Time(){

        return DateTime.getData(0);
    }
    public String Date() {

        return DateTime.getData(1);
    }

    public String numSongs(){
        return String.valueOf(LoadedPlaylist.getSize());
    }

    public void Return(ActionEvent event) throws IOException {
        player.stop();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

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