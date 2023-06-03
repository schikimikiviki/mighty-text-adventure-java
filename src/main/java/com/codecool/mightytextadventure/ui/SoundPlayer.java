package com.codecool.mightytextadventure.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SoundPlayer {
    public static void playSound(String soundFilePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(soundFilePath);
            Player player = new Player(fileInputStream);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
