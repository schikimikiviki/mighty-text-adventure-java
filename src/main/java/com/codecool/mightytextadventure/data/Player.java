package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private String name;
    private int lives;
    private String occupation;
    private boolean hasKey;
    private String[] inventory;

    public Player() {
        this.lives = 3;
        this.hasKey = false;
        this.inventory = new String[5];
        Arrays.fill(inventory, "---");

    }

    public boolean hasItem(String item) {
        for (String inventoryItem : inventory) {
            if (item.equals(inventoryItem)) {
                return true;
            }
        }
        return false;
    }

    public void setInventory(String item) {
        int index = 0;
        while (index < inventory.length &&
                (inventory[index] != null &&
                        !inventory[index].equals("---"))) {
            index++;
        }

        if (index < inventory.length) {
            inventory[index] = item;
        } else {
            System.out.println("Inventory is full. Unable to add item: " + item);
        }
    }


    public String[] getInventory() {
        return inventory;
    }

    public void chooseCharacterAndClass() {
        Display display = new Display();
        Input input = new Input();
        String characterName = "";

        do {
            display.printMessage("Please give the character a name!");
            characterName = input.getInputFromUser();
            if (characterName.isEmpty() || characterName.trim().length() < 1) {
                display.printMessage("The field is empty. Please insert a name that is longer than 1 character.");
            }
        } while (characterName.isEmpty() || characterName.trim().length() < 1);
        this.name = characterName;

        boolean characterChoice = true;
        int choice = 0;

        while (characterChoice) {
            display.printCharacterChoice();

            String userInput = input.getInputFromUser();
            if (isInteger(userInput)) {
                choice = Integer.parseInt(userInput);
                switch (choice) {
                    case 1:
                        occupation = "wizard";
                        System.out.println("\uD83E\uDDD9");
                        characterChoice = false;
                        break;
                    case 2:
                        occupation = "ninja";
                        System.out.println("\uD83E\uDD77");
                        characterChoice = false;
                        break;
                    case 3:
                        occupation = "priest";
                        System.out.println("\uD83D\uDE07");
                        characterChoice = false;
                        break;
                    case 4:
                        occupation = "thief";
                        System.out.println("\uD83D\uDD74");
                        characterChoice = false;
                        break;
                    default:
                        System.out.println("Please insert a number from 1-4.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public String getOccupation() {
        return occupation;
    }

    public void printHelloMessage() {
        System.out.println("Hello " + this.name + ". You are starting with " + this.lives + " lives.  You chose to be a : " + this.occupation);


    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isHasKey() {
        return hasKey;
    }
}