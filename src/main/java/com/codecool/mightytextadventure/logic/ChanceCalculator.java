package com.codecool.mightytextadventure.logic;
import java.util.Random;

public class ChanceCalculator {
    private static final Random random = new Random();

    public static boolean calculate50_50Chance() {
        return random.nextBoolean();
    }
}