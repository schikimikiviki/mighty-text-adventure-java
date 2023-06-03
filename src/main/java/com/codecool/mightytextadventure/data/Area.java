package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.logic.GameOver;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Area {
    private String description;
    private String name;
    private boolean hasWildAnimals;
    private ArrayList<Integer> nextAreas = new ArrayList<>();

    public Area(String name, String description, boolean hasWildAnimals) {
        this.description = description;
        this.name = name;
        this.hasWildAnimals = hasWildAnimals;
    }

    public ArrayList<Integer> getNextAreas() {
        return nextAreas;
    }

    public void setNextAreas(ArrayList<Integer> nextAreas) {
        this.nextAreas = nextAreas;
    }

    public int chooseOption(Player player) {
        Display display = new Display();
        // boolean choiceBoolean = true;
        int index = 0;
        GameOver gameover = new GameOver();

        try {
            Thread.sleep(3000);
            meetAnimal(player);
            actionInArea(player);
            Thread.sleep(3000);
            System.out.println();

            if (player.getLives() >= 1) {
                display.printDirectionOptions();
                index = getDirections();

            } else {
                gameover.gameOver();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return index;
    }

    protected int getNorthIndex() {
        return getNextAreas().get(0);
    }

    protected int getEastIndex() {
        return getNextAreas().get(1);
    }

    protected int getSouthIndex() {
        return getNextAreas().get(2);
    }

    protected int getWestIndex() {
        return getNextAreas().get(3);
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isHasWildAnimals() {
        return hasWildAnimals;
    }

    public void meetAnimal(Player player) {
    }

    public void actionInArea(Player player) {

    }

    public int getDirections() {
        Input input = new Input();
        int index = 0;
        String option = input.getInputFromUser().toLowerCase();
        switch (option) {
            case "n":
            case "north":
                index = getNorthIndex();
                break;
            case "e":
            case "east":
                index = getEastIndex();
                break;
            case "s":
            case "south":
                index = getSouthIndex();
                break;
            case "w":
            case "west":
                index = getWestIndex();
                break;
            case "exit":
                System.exit(0);
        }
        return index;
    }
}
