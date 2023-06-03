package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.GameOver;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Forest extends Area {
    public Forest(String description, String name, boolean hasWildAnimals) {
        super(description, name, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(0, 4, 6, 5)));

    }

    @Override
    public void meetAnimal(Player player) {
        Display display = new Display();
        Input input = new Input();
        DisplayActions actionDisplay = new DisplayActions();
        try {
            actionDisplay.displayActionOfForest();
            int number = input.getIntInputFromUser();
            if (number == 1) {
                switch (player.getOccupation()) {
                    case "wizard":
                        display.printMessage("You cast a spell to defeat the wolves. You create a serum from their blood and earn a life. ");
                        player.setLives(player.getLives() + 1);
                        break;
                    case "ninja":
                        display.printMessage("You fight the wolves with your ninja power and beat their ass. You gather their bones.");
                        player.setInventory("bones");
                        break;
                    case "priest":
                        display.printMessage("You pray to Jesus but this unfortunately does not help and a wolf bites your ass. You manage to escape but lose a life.");
                        player.setLives(player.getLives() - 1);
                        break;
                    case "thief":
                        display.printMessage("You try to throw your gold coins at your opponent but this does not seem to help. They are more aggressive now. You lose two lives and manage to escape.");
                        player.setLives(player.getLives() - 2);
                        break;
                }

            } else {
                display.printMessage("You managed to escape.");
            }
        } catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            input.getInputFromUser(); // Clear the input buffer
            meetAnimal(player);
        }


    }

}

