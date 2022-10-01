package com.example.cemusicplayer;

import com.example.cemusicplayer.DataStructures.DCLinkedList;
import com.example.cemusicplayer.DataStructures.LinkedList;
import com.example.cemusicplayer.InformationManager.FileInList;
import com.example.cemusicplayer.InformationManager.ListInFile;
import com.example.cemusicplayer.MusicManager.XMLController;
import jaco.mp3.player.MP3Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Controlador de la pantalla donde se reproduce las playlists
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
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
    private Button ErraseFavourite;
    @FXML
    private Button FavoriteButton;

    @FXML
    private Button PauseButton;

    @FXML
    private Button LoopButton;

    @FXML
    private ImageView fondoFavorito;

    @FXML
    private ImageView fondoLoop;

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
    private TextArea SongLyrics;
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

    static boolean F = true;

    private int size;

    String PlayingPlaylist;
    MP3Player player = new MP3Player();
    File song;
    static String ChoosedSong;
    File Metadata;

    /**
     * Metodo para reproducir la cancion anterior de la cancion actual y obtener todos sus datos
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void LastSong(ActionEvent event) throws FileNotFoundException {
        if (PlayingPlaylist != null) {
            if (loop == false) {
                ChoosedSong = LoadedPlaylist.getBackItemNotLoop();
                label.setText(ChoosedSong);
                song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
                Metadata = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong + ".xml");
                Genero.setText(XMLController.GetGenero(Metadata));
                Artist.setText(XMLController.GetArtist(Metadata));
                Album.setText(XMLController.GetAlbum(Metadata));
                Year.setText(XMLController.GetYear(Metadata));
                Lyrics.setText(XMLController.GetLyrics(Metadata));
                SongLyrics.setText(XMLController.GetLyrics(Metadata));
                SearchFavorite(ChoosedSong);

                player.addToPlayList(song);
                player.skipForward();

                System.out.println(ChoosedSong);
            } else if (loop == true) {
                String ChoosedSong = LoadedPlaylist.getBackItem();
                label.setText(ChoosedSong);
                song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
                Metadata = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong + ".xml");
                Genero.setText(XMLController.GetGenero(Metadata));
                Artist.setText(XMLController.GetArtist(Metadata));
                Album.setText(XMLController.GetAlbum(Metadata));
                Year.setText(XMLController.GetYear(Metadata));
                Lyrics.setText(XMLController.GetLyrics(Metadata));
                SongLyrics.setText(XMLController.GetLyrics(Metadata));

                SearchFavorite(ChoosedSong);

                player.addToPlayList(song);
                player.skipForward();


                System.out.println(ChoosedSong);
            }
        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();

        }
    }
    /**
     * Metodo para reproducir la cancion siguiente de la cancion actual y obtener todos sus datos
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void NextSong(ActionEvent event) throws FileNotFoundException {
        if (PlayingPlaylist != null) {
            if (!loop) {

                String ChoosedSong = LoadedPlaylist.getNextItemNotLoop();

                song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
                Metadata = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong + ".xml");
                Genero.setText(XMLController.GetGenero(Metadata));
                Artist.setText(XMLController.GetArtist(Metadata));
                Album.setText(XMLController.GetAlbum(Metadata));
                Year.setText(XMLController.GetYear(Metadata));
                Lyrics.setText(XMLController.GetLyrics(Metadata));
                SearchFavorite(ChoosedSong);
                SongLyrics.setText(XMLController.GetLyrics(Metadata));

                player.addToPlayList(song);
                player.skipForward();
                System.out.println(ChoosedSong);
                label.setText(ChoosedSong);
                System.out.println("Loop Song");
            } else if (loop) {
                String ChoosedSong = LoadedPlaylist.getNextItem();//Se llama al siguiente dato de la lista
                song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong);
                Metadata = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + ChoosedSong + ".xml");
                Genero.setText(XMLController.GetGenero(Metadata));
                Artist.setText(XMLController.GetArtist(Metadata));
                Album.setText(XMLController.GetAlbum(Metadata));
                Year.setText(XMLController.GetYear(Metadata));
                Lyrics.setText(XMLController.GetLyrics(Metadata));
                SongLyrics.setText(XMLController.GetLyrics(Metadata));
                SearchFavorite(ChoosedSong);
                player.addToPlayList(song);
                player.skipForward();
                label.setText(ChoosedSong);
                System.out.println(ChoosedSong);
            }
        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();

        }
    }
    /**
     * Metodo para abrir la pantalla de crear playlists
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void LSongs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlaylist.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Metodo para abrir la pantalla de agregar canciones
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void AddMusic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddMusicMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Metodo para eliminar canciones
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void DeleteMusic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteMusicMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    /**
     * Metodo para elimar de la lista favorita
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void DeleteFavourite(ActionEvent event) throws FileNotFoundException {
        if (PlayingPlaylist != null){

            LinkedList<String> list = new LinkedList<>();
            list = FileInList.LoadFileOfStringsIntoList(new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/FavoriteSongs.txt")); //Se agrega el archivo en la lista simple
            int Number;
            Number = list.IndexOfItem(String.valueOf(label));//se agregqa el nombnre de la cancion en el metodo para obtener el indice del elemento
            //Se revisa si el label esta en el txt de favoritos
            if (boolFavorite(String.valueOf(label))==true){
                list.delete(Number);
                ListInFile.CreateFileWithListInfo(list, "Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/FavoriteSongs.txt");//Se coloca la direccion de favortios para volver a crear el archivo sin el nomnbre de la cancion que se elimino
                fondoFavorito.setVisible(false);

            }else{
                Alert message = new Alert(Alert.AlertType.WARNING);
                message.setTitle("Advertencia");
                message.setContentText("Esta cancion no esta en favoritos");
                message.showAndWait();
            }

        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();
        }
    }
    /**
     * Metodo para abrir la pantalla de editar mentadata
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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

    /**
     * Metodo para pausar las canciones
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void Pause(){
        if (PlayingPlaylist != null) {
            PlayButton.setDisable(false);
            player.pause();
            PauseButton.setDisable(true);
        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();
        }

    }
    /**
     * Metodo para reproducir las canciones
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void play(){


        if (PlayingPlaylist != null) {
            PauseButton.setDisable(false);
            player.play();
            PlayButton.setDisable(true);
        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();

        }
    }
    /**
     * Metodo para bajar el volumen
     * @author JobMe Tech Solutions
     * URL=https://www.youtube.com/c/JobMETechSolutions
     */
    public static void volumeDown(Double d){
        Mixer.Info [] mixers= AudioSystem.getMixerInfo(); //Se obtiene la información del sistema de audio en el mixer
        //Se usa un bucle for para enumerar todos los mixer
        for(Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo); //Se obtiene el mixer
            Line.Info[] lineInfo=mixer.getTargetLineInfo(); //Se obtiene la línea de destino
            // Se usa bucle para listar líneas
            for(Line.Info lineI:lineInfo){
                Line line =null; //Se hace null la linea
                boolean open = true;//Se hace un booleano en true
                //Se use la excepción de prueba para abrir una línea
                try{
                    line=mixer.getLine(lineI);
                    open=line.isOpen() || line instanceof Clip;
                    //Se revisa si la line no esta abierta
                    if(!open){
                        //Se abre la línea
                        line.open();
                    }
                    //Se hace un control flotante
                    FloatControl controlV = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    //Se obtiene el volumen actual
                    float current=controlV.getValue();
                    //Se hace una variable temporal doble y se almacena el valor de que es un double y es la cantidad de volumen que se bajara o subira
                    Double volumeC=d;
                    //Se hace un blotante y se calcula la suma o disminución del volumen
                    float change=(float) ((float)current-(double)volumeC);
                    //Se establece el valor cambiado en la línea de volumen
                    controlV.setValue(change);
                } catch (LineUnavailableException lineUnavailableException) {
                }catch (IllegalArgumentException illegalArgumentException){
                }finally {
                    //Se cierra la línea si se abrio
                    if(line!=null && !open){
                        line.close();
                    }
                }
            }
        }
    }
    /**
     * Metodo para subir el volumen
     * @author JobMe Tech Solutions
     * URL=https://www.youtube.com/c/JobMETechSolutions
     */
    public static void volumeUp(Double d){

        Mixer.Info [] mixers= AudioSystem.getMixerInfo(); //Se obtiene la información del sistema de audio en el mixer
        //Se usa un bucle for para enumerar todos los mixer
        for(Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo); //Se obtiene el mixer
            Line.Info[] lineInfo=mixer.getTargetLineInfo(); //Se obtiene la línea de destino
            // Se usa bucle para listar líneas
            for(Line.Info lineI:lineInfo){
                Line line =null; //Se hace null la linea
                boolean open = true;//Se hace un booleano en true
                //Se use la excepción de prueba para abrir una línea
                try{
                    line=mixer.getLine(lineI);
                    open=line.isOpen() || line instanceof Clip;
                    //Se revisa si la line no esta abierta
                    if(!open){
                        //Se abre la línea
                        line.open();
                    }
                    //Se hace un control flotante
                    FloatControl controlV = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    //Se obtiene el volumen actual
                    float current=controlV.getValue();
                    //Se hace una variable temporal doble y se almacena el valor de que es un double y es la cantidad de volumen que se bajara o subira
                    Double volumeC=d;
                    //Se hace un blotante y se calcula la suma o disminución del volumen
                    float change=(float) ((float)current+(double)volumeC);
                    //Se establece el valor cambiado en la línea de volumen
                    controlV.setValue(change);
                } catch (LineUnavailableException lineUnavailableException) {
                }catch (IllegalArgumentException illegalArgumentException){
                }finally {
                    //Se cierra la línea si se abrio
                    if(line!=null && !open){
                        line.close();
                    }
                }
            }
        }

    }
    /**
     * Metodo para llamar al metodo de subir volumen
     * @author JobMe Tech Solutions
     * URL=https://www.youtube.com/c/JobMETechSolutions
     */
    public void Up(){
        volumeUp(0.2);
    }
    /**
     * Metodo para llamar al metodo de bajar volumen
     * @author JobMe Tech Solutions
     * URL=https://www.youtube.com/c/JobMETechSolutions
     */
    public void down(){
        volumeDown(0.2);
    }
    /**
     * Metodo para buscar la cancion actual en el txt y mostrar un image view si lo esta
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public Void SearchFavorite(String song) throws FileNotFoundException {

        Scanner favorite = new Scanner(song);
        String cancion = favorite.next();
        String email = SignInController.getEmail();
        File file = new File("Users/" + email + "/" + PlayingPlaylist + "/FavoriteSongs.txt");
        Scanner scanner;

        //Se coloca en el scanner el archivo para leerlo
        scanner = new Scanner(file);
        //Se hace un while para que se lea mientras haya siguiente línea
        while (scanner.hasNext()) {
            final String lineFromFile = scanner.nextLine();
            //Se verifica si la line contiene el string que es el nombre de la cancion
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
    /**
     * Metodo para buscar la cancion actual en el txt y si esta retornar true y si no retornar false
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public Boolean boolFavorite(String song) throws FileNotFoundException {
        Scanner favorite = new Scanner(song);//Se coloca el string en un scanner
        String cancion = favorite.next();
        String email = SignInController.getEmail();
        File file = new File("Users/" + email + "/" + PlayingPlaylist + "/FavoriteSongs.txt");
        Scanner scanner;
        scanner = new Scanner(file); //Se coloca en el scanner el archivo para leerlo
        //Se hace un while para que se lea mientras haya siguiente línea
        while (scanner.hasNext()) {
            final String lineFromFile = scanner.nextLine();
            //Se verifica si la line contiene el string que es el nombre de la cancion
            if (lineFromFile.contains(cancion)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo para agregar el nombre de la cancion actual al txt de favoritos y mostrar el image view
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void AddFavorite(ActionEvent event) throws IOException {
        String Email = SignInController.getEmail();
        System.out.println(label);

        if (PlayingPlaylist != null){
            File LoadedSongs = new File("Users/" + Email + "/" + PlayingPlaylist + "/FavoriteSongs.txt");
            FileWriter LoadedSongsFileWriter = new FileWriter(LoadedSongs, true);
            BufferedWriter Songsbw = new BufferedWriter(LoadedSongsFileWriter);

            Songsbw.write(String.valueOf(label));
            Songsbw.newLine();
            Songsbw.close();
            LoadedSongsFileWriter.close();
            SearchFavorite(String.valueOf(label));//Se llama a la funcion de buscar favoritos para que aparezca el image view de favoritos

        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor elija una playlist");
            message.showAndWait();
        }
        fondoFavorito.setVisible(true);
    }
    /**
     * Metodo para detectar la playlist que escogio el usuario y reproducir la primera cancion y mostrar todos los datos de la cancion
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void PlaylistChooser(ActionEvent event) throws FileNotFoundException {
        String selected = Playlist.getSelectionModel().getSelectedItem(); //Se obtiene el nombre de la playlist
        PlayingPlaylist = selected;
        File play=new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/LoadedSongs.txt");

        DateTime = FileInList.LoadFileOfStringsIntoDCLinkedList(new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/DateTime.txt"));

        date.setText("Fecha: " +Date());
        time.setText("Hora: " + Time());
        //Se revisa si el archivo llamado play exista
        if (play.exists()){

            LoadedPlaylist = FileInList.LoadFileOfStringsIntoDCLinkedList(play);//Se agrega el archivo llamado play en una lista doblemente enlazada circular

            song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getNextItem());
            Metadata= new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getData(0)+".xml");
            label.setText(LoadedPlaylist.getData(0));
            Genero.setText(XMLController.GetGenero(Metadata));
            Artist.setText(XMLController.GetArtist(Metadata));
            Album.setText(XMLController.GetAlbum(Metadata));
            Year.setText(XMLController.GetYear(Metadata));
            Lyrics.setText(XMLController.GetLyrics(Metadata));
            SearchFavorite(LoadedPlaylist.getData(0));
            player.addToPlayList(song);
            player.play();
            num.setText("Canciones: " + numSongs());
            size = LoadedPlaylist.getSize();



        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor agregue canciones a su playlist");
            message.showAndWait();



        }

    }
    /**
     * Metodo para buscar cambiar un booleano y asi cambiar la forma del get back y get next
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @FXML
    void Loop(ActionEvent event)  {
        if (PlayingPlaylist != null) {

            if (loop == false) {
                //player.stop();
                System.out.println("pone loop");
                fondoLoop.setVisible(true);
                loop = true;
                System.out.println(loop);
            } else {
                // song = new File("Users/" + SignInController.getEmail() + "/" + PlayingPlaylist + "/" + LoadedPlaylist.getNext());
                fondoLoop.setVisible(false);
                loop = false;
                System.out.println("quita loop");
                System.out.println(loop);
            }
        }else{
            Alert message = new Alert(Alert.AlertType.WARNING);
            message.setTitle("Advertencia");
            message.setContentText("Por favor agregue canciones a su playlist");
            message.showAndWait();
        }
    }
    /**
     * Metodo para ir a la ventana de eliminar playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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
    /**
     * Metodo para ir a la ventana de agregar favoritos de cualquier playlist que el usuario haya creado
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */

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

    /**
     * Metodo para obtener la hora de creacion de la playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public String Time(){

        return DateTime.getData(0);
    }
    /**
     * Metodo para obtener la fecha de creacion de la playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public String Date() {

        return DateTime.getData(1);
    }
    /**
     * Metodo para obtener el número de canciones que hay en una playlist
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public String numSongs(){
        return String.valueOf(LoadedPlaylist.getSize());
    }
    /**
     * Metodo para regresar a la ventana de login
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void Return(ActionEvent event) throws IOException {
        player.stop();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Metodo para mostrar las canciones de cada playlist en un comboBox
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ExistingPlaylist = new File("Users/" + SignInController.getEmail() + "/ExistingPlaylist.txt");
        LinkedList<String> list = new LinkedList<>();
        try {
            list = FileInList.LoadFileOfStringsIntoList(ExistingPlaylist);//Se coloca en lista simplemente enlazada el archivo de playlist existente
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Se revisa si lista es mayor a 0
        if (list.getSize() > 0){
            //Se agrega el nombre de la playlist mientras i sea menor al largo de la lista
            for(int i = 0; i < list.getSize(); i++){
                Playlist.getItems().add(list.getNext());//Se obtiene el nombre de la playliist y se agrega a la lista
            }
        }
    }
}