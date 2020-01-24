package me.mafrans.hangman;

import org.apache.commons.lang.StringUtils;

import java.awt.*;
import java.beans.Expression;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HangmanManager {
    private Letter[] letters;
    private int failures;

    public HangmanManager(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) { // Loop over every letter in the word
            String ch = String.valueOf(word.charAt(i));
            Letter letter = new Letter(ch);

            letter.visible = false;
            letters[i] = letter;
        }
    }

    public boolean tryLetter(String letter) {
        boolean show = showLetter(letter);
        if (!show) {
            failures++;
        }
        render(failures);
        return show;
    }

    public boolean showLetter(String letter) {
        boolean out = false;
        for(Letter l : letters) {
            if (l.letter.equalsIgnoreCase(letter)) {
                l.visible = true;
                out = true;
            }
        }
        return out;
    }

    public void showAll() {
        for(Letter l : letters) {
            l.visible = true;
        }
    }

    public void render(int failures) {
        Scanner in = new Scanner(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("hangman-" + failures + ".txt")));
        StringBuilder bob = new StringBuilder();
        while(in.hasNextLine()) {
            bob.append(in.nextLine() + "\n");
        }
        bob.append("\n");
        bob.append(StringUtils.repeat(" ", (28 - letters.length*2)/2));

        for(Letter l : letters) {
            bob.append((l.visible || l.letter.equals(" ") ? l.letter : "_") + " ");
        }
        bob.append("\n");

        Console.render(bob.toString());
    }

    public void render() {
        render(failures);
    }

    public int getFailures() {
        return failures;
    }

    public Letter[] getLetters() {
        return letters;
    }
}
