package me.mafrans.hangman;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public String getLetter() {
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        Matcher matcher = Pattern.compile("[A-Za-z]").matcher(letter);

        return matcher.find() && letter.length() == 1 ? letter : null;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
