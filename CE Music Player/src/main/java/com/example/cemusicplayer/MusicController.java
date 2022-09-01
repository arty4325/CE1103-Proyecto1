package com.example.cemusicplayer;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class MusicController {
    MP3Player player;
    File song=new File("C:\\Datos1\\Practicas\\CE1103-Proyecto1\\MP3\\Slipknot - Snuff  Español.mp3");


    public void play() {

    player=new MP3Player();
    player.addToPlayList(song);
    player.play();
    }

    public void Pause(){
        player.pause();
    }
    public void playAgain(){
        player.play();
    }
}
