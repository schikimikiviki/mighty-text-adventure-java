package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Beach extends Area {
    public Beach(String description, String name, boolean hasWildAnimals) {
        super(description, name, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(1, 5, 6, 3)));

    }

    @Override
    public void meetAnimal(Player player) {
        Display display = new Display();
        Input input = new Input();
        DisplayActions actionDisplay = new DisplayActions();
        try {
            actionDisplay.displayActionOfBeach();
            int number = input.getIntInputFromUser();
            if (number == 1) {
                switch (player.getOccupation()) {
                    case "wizard":
                        display.printMessage("One of the seagulls is able to steal your magic wand. You loose one life.");
                        player.setLives(player.getLives() - 1);
                        break;
                    case "ninja":
                        display.printMessage("The seagulls beat your ass. You are left with bruises and bloody knees.");
                        break;
                    case "priest":
                        display.printMessage("You use your bible as a shield and the seagulls feel the holy spirit and pray with you. You gain a life. ");
                        player.setLives(player.getLives() + 1);
                        break;
                    case "thief":
                        display.printMessage("You steal the seagulls eggs and make yourself an omelette. You gain a life.");
                        player.setLives(player.getLives() + 1);
                        break;
                }

            } else {
                display.printMessage("You managed to escape.");
            }
        } catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            input.getInputFromUser();
            meetAnimal(player);
        }


    }


}

