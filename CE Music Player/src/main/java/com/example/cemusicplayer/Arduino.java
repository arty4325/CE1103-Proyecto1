package com.example.cemusicplayer;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Objects;
import java.util.Scanner;

public class Arduino extends Thread {
    Boolean Flag1;
    Boolean Flag2;
    Boolean Flag3;
    Boolean Flag4;
    Boolean Flag5;
    Boolean SecondFlag1;
    Boolean SecondFlag2;
    Boolean SecondFlag3;
    Boolean SecondFlag4;
    Boolean SecondFlag5;



    @Override
    public void run() {
        Flag1 = false;
        Flag2 = false;
        Flag3 = false;
        Flag4 = false;
        Flag5 = false;
        SecondFlag1 = true;
        SecondFlag2 = true;
        SecondFlag3 = true;
        SecondFlag4 = true;
        SecondFlag5 = true;
        SerialPort port = SerialPort.getCommPort("COM4");
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

        Scanner scanner = new Scanner(port.getInputStream());
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] bytes = line.split(",");
            //System.out.println(Arrays.toString(bytes));
            if (bytes.length >= 10) {
                if (Objects.equals(bytes[0], "1") && Objects.equals(bytes[1], "0")) {
                    if (!Flag1) {
                        System.out.println("Primer Caso");
                        //MusicPlayerController.volumeUp(0.2);
                        Flag1 = true;
                        SecondFlag1 = false;
                    }
                }
                if (Objects.equals(bytes[1], "1") && Objects.equals(bytes[2], "0")) {
                    if (!Flag2) {
                        System.out.println("Segundo Caso");
                        MusicPlayerController.volumeUp(0.2);
                        Flag2 = true;
                        SecondFlag2 = false;
                    }
                }
                if (Objects.equals(bytes[2], "1") && Objects.equals(bytes[3], "0")) {
                    if (!Flag3) {
                        System.out.println("Tercer Caso");
                        MusicPlayerController.volumeUp(0.2);
                        Flag3 = true;
                        SecondFlag3 = false;
                    }
                }
                if (Objects.equals(bytes[3], "1") && Objects.equals(bytes[4], "0")) {
                    if (!Flag4) {
                        System.out.println("Cuarto Caso");
                        MusicPlayerController.volumeUp(0.2);
                        Flag4 = true;
                        SecondFlag4 = false;
                    }
                }
                if (Objects.equals(bytes[4], "1")) {
                    if (!Flag5) {
                        System.out.println("Quinto Caso");
                        MusicPlayerController.volumeUp(0.2);
                        Flag5 = true;
                        SecondFlag5 = false;
                    }
                }
                if (Objects.equals(bytes[4], "0")){
                    if (Flag5 && !SecondFlag5){
                        System.out.println("Primera Bajada");
                        Flag5 = false;
                        SecondFlag5 = true;
                        MusicPlayerController.volumeDown(0.2);
                    }
                }
                if (Objects.equals(bytes[3], "0") && Objects.equals(bytes[2], "1")) {
                    if (Flag4 && !SecondFlag4){
                        System.out.println("Segunda Bajada");
                        Flag4 = false;
                        SecondFlag4 = true;
                        MusicPlayerController.volumeDown(0.2);
                    }
                }
                if (Objects.equals(bytes[2], "0") && Objects.equals(bytes[1], "1")){
                    if (Flag3 && !SecondFlag3){
                        System.out.println("Tercera Bajada");
                        Flag3 = false;
                        SecondFlag3 = true;
                        MusicPlayerController.volumeDown(0.2);
                    }
                }
                if (Objects.equals(bytes[1], "0") && Objects.equals(bytes[0], "1")){
                    if (Flag2 && !SecondFlag2){
                        System.out.println("Cuarta Bajada");
                        Flag2 = false;
                        SecondFlag2 = true;
                        MusicPlayerController.volumeDown(0.2);
                    }
                }
                if (Objects.equals(bytes[0], "0") && Objects.equals(bytes[1], "0")){
                    if (Flag1 && !SecondFlag1){
                        System.out.println("Quinta Bajada");
                        Flag1 = false;
                        Flag2 = false;
                        Flag3 = false;
                        Flag4 = false;
                        Flag5 = false;
                        SecondFlag1 = true;
                        SecondFlag2 = true;
                        SecondFlag3 = true;
                        SecondFlag4 = true;
                        SecondFlag5 = true;
                        //MusicPlayerController.volumeDown(0.2);
                    }
                }
                if (Objects.equals(bytes[5], "1")){
                    System.out.println("Funciona next");
                }
                if (Objects.equals(bytes[6], "1")){
                    System.out.println("Funciona back");

                }
                if (Objects.equals(bytes[7], "1")){
                    System.out.println("Funciona el play");
                }
                if (Objects.equals(bytes[8], "1")){
                    System.out.println("Funciona pausa");

                }
                if (Objects.equals(bytes[9], "1")){
                    System.out.println("Funciona Loop");
                }
                if (Objects.equals(bytes[10], "1")){
                    System.out.println("Funciona Fav");
                }

            }
        }
    }
}