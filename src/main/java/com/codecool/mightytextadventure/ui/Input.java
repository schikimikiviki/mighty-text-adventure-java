package com.codecool.mightytextadventure.ui;

import java.util.Scanner;

public class Input {

    Scanner src = new Scanner(System.in);


    public String getInputFromUser() {
        return src.nextLine();
    }

    public int getIntInputFromUser() {
        int input = src.nextInt();
        src.nextLine(); // Consume the newline character after reading the integer input
        return input;
    }

}
