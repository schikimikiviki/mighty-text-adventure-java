package com.codecool.mightytextadventure.logic;

public class GameOver {

    public static void gameOver() {
        try {
            System.out.println("");
            System.out.println("\u2620\ufe0f \u2620\ufe0f \u2620\ufe0f \u2620\ufe0f");
            System.out.println("GAME OVER");
            //Thread.sleep(2000);
            System.out.println("\u2620\ufe0f \u2620\ufe0f \u2620\ufe0f \u2620\ufe0f");
            System.exit(0);
        } catch (Exception e) {
            System.out.printf("An error occurred: " + e.getMessage());
        }
    }
}
