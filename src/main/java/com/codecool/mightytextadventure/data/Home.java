package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.ChanceCalculator;
import com.codecool.mightytextadventure.logic.GameOver;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

import java.util.*;


public class Home extends Area {
    public Home(String description, String name, boolean hasWildAnimals) {
        super(description, name, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(6, 1, 3, 2)));
    }

    @Override
    public void actionInArea(Player player) {
        Display display = new Display();
        DisplayActions actionDisplay = new DisplayActions();
        Input input = new Input();

        try {
            actionDisplay.displayActionOfHome();
            int answer = input.getIntInputFromUser();
            switch (answer) {
                case 1:
                    display.printMessage("This is your inventory: ");
                    display.printMessage(Arrays.toString(player.getInventory()));
                    break;
                case 2:
                    if (player.isHasKey()) {
                        try {
                            display.printMessage("You have the key to open the mysterious box now!");
                            display.printMessage("You open the box and what you see in it shocks you ..  It's a letter from your long-lost brother!");
                            display.printMessage("You are unsure - do you want to read the letter? ");
                            display.printMessage("Press [Y] or [N]");
                            String answerToBox = input.getInputFromUser();

                            if (answerToBox.equals("Y")) {
                                display.printLetter(player);

                            }
                            display.printMessage("You WON");

                            if (answerToBox.equals("Y")) {
                                display.printMessage("If you want to know what happened to Robert in Spain, get ready to play the MIGHTY TEXT ADVENTURE PART 2!");
                            }

                            System.exit(0);
                        } catch (Exception e) {
                            display.printMessage("An error occurred: " + e.getMessage());
                        }
                    } else {
                        display.printMessage("Hmm, the box seems to be really hard to open. Maybe a key would help. ");
                    }

                    break;
                case 3:
                    if (ChanceCalculator.calculate50_50Chance()) {
                        player.setLives(player.getLives() + 1);
                        display.printMessage("You enjoy a couple of hours of sleep. You gained a life!");
                    } else {

                        player.setLives(player.getLives() - 1);
                        display.printMessage("You have a nightmare! You lost a life!");
                    }
                    break;
                case 4:
                    // you need the wifi pass to do this
                    if (player.hasItem("Piece of paper with WIFI Code")) {
                        display.printMessage("You surf the web and find out something interesting about a criminal group in Spain, they are called S-N-A-K-E. You find out that they abduct tourists and use them for their purposes ... ");
                    } else {
                        display.printMessage("Damn! You need an internet connection for your research!");
                    }
                    break;
            }


        } catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            input.getInputFromUser();
            actionInArea(player);
        }
    }


}