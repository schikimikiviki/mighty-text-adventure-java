package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.GameOver;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Airport extends Area {
    public Airport(String name, String description, boolean hasWildAnimals) {
        super(name, description, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(6, 0, 5, 1)));

    }

    @Override
    public void actionInArea(Player player) {
        DisplayActions actionDisplay = new DisplayActions();
        Display display = new Display();
        Input input = new Input();

        try {

            actionDisplay.displayActionOfAirport();
            int answer = input.getIntInputFromUser();
            switch (answer) {
                case 1:
                    display.printMessage("You find a piece of paper with a number combination reading 0635, how strange ... ");
                    player.setInventory("Piece of paper with WIFI Code");
                    break;
                case 2:
                    if (player.hasItem("money")) {
                        display.printMessage("You buy a ticket to Spain for next week. This will be fun!");
                        player.setInventory("ticket to spain");
                    } else {
                        display.printMessage("You don't have enough money to buy a ticket. What a shame!");
                    }
                    break;
                case 3:
                    if (player.getOccupation().equals("thief")) {
                        display.printMessage("You manage to break into gate 4. You find a hammer and take it with you, maybe it can be useful .. ");
                        player.setInventory("Hammer");
                    } else {
                        display.printMessage("You get in trouble for trying to break in and lose a life.");
                        player.setLives(player.getLives() - 1);
                    }
                    break;
                case 4:
                    break;
            }


        } catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            input.getInputFromUser(); // Clear the input buffer
            actionInArea(player);
        }


    }


}
