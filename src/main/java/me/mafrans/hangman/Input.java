package me.mafrans.hangman;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    /**
     * Asks the player to enter a letter from a to z, also makes sure that other letters or symbols cannot be entered as they are not part of the english alphabet.
     * @return Returns the letter if it corresponds with the criteria, returns null if it doesn't.
     */
    public String getLetter() {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.nextLine();
        Matcher matcher = Pattern.compile("[A-Za-z]").matcher(letter);

        return matcher.find() && letter.length() == 1 ? letter : null;
    }

    /**
     * Asks the player to input something.
     * @return Returns what the player inputs.
     */
    public String getInput() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        return input;
    }

}
