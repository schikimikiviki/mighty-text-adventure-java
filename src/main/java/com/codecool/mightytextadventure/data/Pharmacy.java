package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.ui.Display;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

public class Pharmacy extends Area {
    public Pharmacy(String description, String name, boolean hasWildAnimals) {
        super(description, name, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(2, 3, 6, 4)));

    }

    @Override
    public void actionInArea(Player player) {
        Display display = new Display();
        Input input = new Input();
        DisplayActions actionDisplay = new DisplayActions();
        try {
            actionDisplay.displayActionOfPharamcy();
            int answer = input.getIntInputFromUser();
            switch (answer) {
                case 1:
                    player.setHasKey(true);
                    player.setInventory("Mysterious key");
                    display.printMessage("WOW. You have found a key. How wonderful.");
                    break;
                case 2:
                    player.setLives(player.getLives() + 1);
                    display.printMessage("OH YES! You drank medicine and gained a life.");
                    display.printMessage("You have " + player.getLives() + " left.");
                    break;
                case 3:
                    player.setLives(player.getLives() - 1);
                    display.printMessage("OH NO. YOU Lost a live");
                    display.printMessage("You have " + player.getLives() + " left.");
                    break;
                case 4: break;
            }


        } catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            input.getInputFromUser();
            actionInArea(player);
        }
    }


}

