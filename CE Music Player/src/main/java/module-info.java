module com.example.cemusicplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires jaco.mp3.player;
    requires org.jdom2;


    opens com.example.cemusicplayer to javafx.fxml;
    exports com.example.cemusicplayer;
    exports com.example.cemusicplayer.MusicManager;
    opens com.example.cemusicplayer.MusicManager to javafx.fxml;
}