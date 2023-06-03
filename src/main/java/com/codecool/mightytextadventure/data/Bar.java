package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.GameOver;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.DisplayActions;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bar extends Area {
    public Bar(String description, String name, boolean hasWildAnimals) {
        super(description, name, hasWildAnimals);
        setNextAreas(new ArrayList<>(List.of(6, 2, 4, 0)));

    }

    @Override
    public void actionInArea(Player player) {
        Scanner src = new Scanner(System.in);
        Display display = new Display();
        DisplayActions newDisplayAction = new DisplayActions();
        Input input = new Input();

        try {
            newDisplayAction.displayActionOfBar();
            int answer = input.getIntInputFromUser();
            switch (answer) {
                case 1:
                    display.printMessage("You drink some margaritas with the girl. Her name is Alice and she works as a singer. After a few hours she kisses you goodbye and leaves you her number");
                    player.setInventory("Piece of paper with Alice's number");
                    break;
                case 2:
                    display.printMessage("You take some time for yourself and think about your brother, who left you last summer without saying a word ... You really miss him. ");
                    display.printMessage("You order one bloody mary after another and get blackout drunk. ");
                    display.printMessage("You loose a life.");
                    player.setLives(player.getLives() - 1);
                    break;
                case 3:
                    display.printMessage("It turns out the guy is a former classmate of Robert. He tells you one very interesting fact: In their last chat, Robert told him that he had to do errands at the SwiftCare Pharmacy. The strange thing about this statement was: The SwiftCare Pharmacy has been closed due to financial instability nearly two years ago. You both wonder what Robert meant by this.");
                    break;
                case 4:
                    break;
            }


        } catch (InputMismatchException e) {
            display.printMessage("Invalid input. Please enter a valid integer.");
            src.nextLine(); // Clear the input buffer
            actionInArea(player);

        }

    }


}