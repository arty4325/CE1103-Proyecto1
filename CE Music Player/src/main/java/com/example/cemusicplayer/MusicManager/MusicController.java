package com.example.cemusicplayer.MusicManager;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class MusicController {
    MP3Player player;
    File song=new File("MP3\\Slipknot - Snuff  Español.mp3");


    public void play() {

    player=new MP3Player();
    player.addToPlayList(song);
    player.play();
    }

    public void Pause(){
        player.pause();
    }
}
