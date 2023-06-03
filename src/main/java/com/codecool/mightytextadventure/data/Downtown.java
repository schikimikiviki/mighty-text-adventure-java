package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.GameOver;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Downtown extends Area {
    public Downtown(String description, String name, boolean hasWildAnimals) {
        super(description, name, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(0, 0, 3, 0)));

    }


    @Override
    public void meetAnimal(Player player) {
        Display display = new Display();
        Input input = new Input();
        DisplayActions actionDisplay = new DisplayActions();
        try {
            actionDisplay.displayActionOfDowntown();
            int number = input.getIntInputFromUser();
            if (number == 1) {
                switch (player.getOccupation()) {
                    case "wizard":
                        display.printMessage("You try to fight the racoons, but they are too cute to be fought. You lose a life.");
                        player.setLives(player.getLives() - 1);
                        break;
                    case "ninja":
                        display.printMessage("The racoons are not as strong and fast as you are! You earn a life");
                        player.setLives(player.getLives() + 1);
                        break;
                    case "priest":
                        display.printMessage("You try to splash the crazy racoons with holy water. They get furious and take away your bible");
                        break;
                    case "thief":
                        display.printMessage("You try to steal the racoons vibe, but fail miserably. You should be happy to be alive");
                        player.setLives(player.getLives() - 3);

                        //ur verprügelt haha
                        break;
                }

            } else {
                display.printMessage("You managed to escape.");
            }
        }
        catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            input.getInputFromUser();
            meetAnimal(player);
        }


    }


}
