package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.data.Player;

public class Display {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printIfAnimalsArePresent() {
        System.out.println("------------------------");
        System.out.println("\u001B[31mAttention. There may be wild animals in this area. Be careful.\u001B[0m");
        System.out.println("------------------------");
    }

    public void printAreaNameAndDescription(String areaName, String areaDescription, Player player) {
        System.out.print("\u001B[32m" + areaName + "\u001B[0m");
        System.out.print("         [ Lives: " + player.getLives() + "]");
        System.out.println("");
        System.out.println("\u001B[42m" + areaDescription + "\u001B[0m");
    }

    public void printDirectionOptions() {
        System.out.println("Please choose an option:");
        System.out.println("[N] or [NORTH] Go north");
        System.out.println("[E] or [EAST] Go east");
        System.out.println("[S] or [SOUTH] Go south");
        System.out.println("[W] or [WEST] Go west");
        System.out.println("[EXIT] Exit the game");
    }

    public void printCharacterChoice() {
        System.out.println("Please choose your characters class.");
        System.out.println("[1]: wizard");
        System.out.println("[2]: ninja");
        System.out.println("[3]: priest");
        System.out.println("[4]: thief");

    }

    public void printWinningMessageWhenArrivingHome() {
        System.out.println("You have the key to open the mysterious box now!");
        System.out.println("You open the box and what you see in it shocks you ..  It's a letter from your long-lost brother!");
        System.out.println("You are unsure - do you want to read the letter? ");
        System.out.println("Press [Y] or [N]");
    }

    public void printLetter(Player player) {
        System.out.println("The letter reads: ");
        String horizontalLine = "-------------------------------------------------------------------------------------------------------";
        String verticalLine = "                                                                                                        ";
        String greeting2 = "                      Dear " + player.getName() + ",                                                       ";
        String message1 = " First of all, sorry for disappearing without even saying goodbye.                                          ";
        String message6 = " Let me explain why I needed to do this:                                                                    ";
        String message2 = " After my breakup with Stella I had a hard time getting back into my usual life. It felt like I was missing ";
        String message3 = " out on something. Every day felt the same, and I felt like being trapped in a loop with no exit. I even    ";
        String message4 = " thought about suicide. But then my friend Marco came around and invited me to his house in Spain. Seemed   ";
        String message5 = " like a good idea to me, get away from this boring city, get some fresh air, meet some new people ...       ";
        String closing = "                   Sincerely,                                                                                ";
        String signature = "                    Robert                                                                                 ";


        System.out.println(horizontalLine);
        System.out.println(verticalLine);
        System.out.println(greeting2);
        System.out.println(verticalLine);
        System.out.println(message1);
        System.out.println(message6);
        System.out.println(message2);
        System.out.println(message3);
        System.out.println(message4);
        System.out.println(message5);
        System.out.println(verticalLine);
        System.out.println(closing);
        System.out.println(verticalLine);
        System.out.println(signature);
        System.out.println(verticalLine);
        System.out.println(horizontalLine);
    }

    public static void getHelp(){
        System.out.println("------------------");
        System.out.println("This is how you play Mighty Text Adventure:");
        System.out.println("Choose a name and a class for your player carefully. The class can later decide weather you win or lose in fights. ");
        System.out.println("Navigate through the game and discover the areas. ");
        System.out.println("Pick up items that may be useful. You can check your inventory at Home.");
        System.out.println("Everything might be clue, so read the information on the screen carefully. ");
        System.out.println("------------------");
    }

}
