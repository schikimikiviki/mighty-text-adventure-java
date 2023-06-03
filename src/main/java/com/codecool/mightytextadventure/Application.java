package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.*;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;
import com.codecool.mightytextadventure.ui.SoundPlayer;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();


        display.printMessage("");
        display.printMessage("Starting Mighty Text Adventure!");

        display.printMessage("Show instructions? Type [Y] or [N]");
        String showInstructions = input.getInputFromUser().toUpperCase();

        if (showInstructions.equals("Y")) {
            Display.getHelp();
        }

        Area[] areas = loadAreas();

        Game game = new Game(areas, input, display);
        game.run();

        display.printMessage("Exiting from Mighty Text Adventure!");
    }

    private static Area[] loadAreas() {
        Area[] areas = new Area[7];
        areas[0] = new Home("Home", "You arrived at home. What a cozy place to stay! You really enjoy staying at home, the only thing you don't understand is how to open the mysterious box you found in the attic.", false);
        areas[1] = new Bar("Bar", "Welcome to The Rusty Mug, a bustling bar filled with lively conversations and clinking glasses. The dimly lit ambiance sets the mood as patrons enjoy their favorite drinks, while laughter and music fill the air.", false);
        areas[2] = new Airport("Airport", "Welcome to Horizon Airport, where the scent of jet fuel fills the air and the constant hum of engines creates an atmosphere of excitement. Check-in counters, departure screens, and the occasional announcement remind you that adventure awaits.", false);
        areas[3] = new Forest("Forest", "Enter the Enchanted Woods, a lush forest brimming with ancient trees, dappled sunlight, and a chorus of birdsong. Explore winding trails, discover hidden clearings, and feel a sense of wonder as nature embraces you in its tranquil embrace.", true);
        areas[4] = new Beach("Beach", "Feel the warm sand beneath your toes at Sunray Beach, a paradise where crystal-clear waters meet endless stretches of golden shoreline. Bask in the sun, listen to the soothing sound of waves, and let the gentle breeze whisk your worries away.", true);
        areas[5] = new Pharmacy("Pharmacy", "Welcome to SwiftCare Pharmacy, your one-stop destination for health and wellness. The bright and clean aisles are stocked with a wide range of medications, personal care products, and friendly pharmacists ready to assist you with expert advice.", false);
        areas[6] = new Downtown("Downtown", "Immerse yourself in the urban buzz of MetroCenter, the dynamic downtown district. Neon lights illuminate the streets as people rush by, surrounded by a diverse array of shops, cultural landmarks, and the aroma of delicious street food.", true);
        return areas;
    }
}
