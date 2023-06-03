package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Game {
    private final Area[] areas;
    private final Input input;
    private final Display display;

    public Game(Area[] areas, Input input, Display display) {
        this.areas = areas;
        this.input = input;
        this.display = display;
    }

    public void run() {
        boolean isRunning = true;
        Player player = new Player();
        player.chooseCharacterAndClass();
        player.printHelloMessage();
        display.printMessage("");
        display.printAreaNameAndDescription(areas[0].getName(), areas[0].getDescription(), player);
        int index = areas[0].chooseOption(player);

        while (isRunning) {
            display.printAreaNameAndDescription(areas[index].getName(), areas[index].getDescription(), player);
            display.printMessage("");
            if (areas[index].isHasWildAnimals()) {
                display.printIfAnimalsArePresent();
            }
            index = areas[index].chooseOption(player);




        }

        System.exit(0); // Exit the program after the game ends
    }


}
