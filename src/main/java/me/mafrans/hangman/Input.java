package me.mafrans.hangman;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public boolean getinput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a letter from A to Z");

        String letter = scanner.nextLine();
        Matcher matcher = Pattern.compile("[A-Za-z]").matcher(letter);
        matcher.find();

        return matcher.find() && letter.length() == 1;
    }
}
