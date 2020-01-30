package me.mafrans.hangman;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;
import java.util.Scanner;

public class HangmanManager {
    private Letter[] letters;
    private int failures;

    public HangmanManager(final String word) {
        letters = new Letter[word.length()];

        // Loop over every letter in the word
        for (int i = 0; i < word.length(); i++) {
            String ch = String.valueOf(word.charAt(i));
            Letter letter = new Letter(ch);

            letter.setVisible(false);
            letters[i] = letter;
        }
    }

    public boolean tryLetter(final String letter) {
        boolean show = showLetter(letter);
        if (!show) {
            failures++;
        }
        render(failures);
        return show;
    }

    public boolean showLetter(final String letter) {
        boolean out = false;
        for (Letter l : letters) {
            if (l.getLetter().equalsIgnoreCase(letter)) {
                l.setVisible(true);
                out = true;
            }
        }
        return out;
    }

    public void showAll() {
        for (Letter l : letters) {
            l.setVisible(true);
        }
    }

    public void render(final int failures) {
        Scanner in = new Scanner(
                Objects.requireNonNull(
                        ClassLoader.getSystemResourceAsStream(
                                "hangman-" + failures + ".txt")));
        StringBuilder bob = new StringBuilder();

        int maxLength = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() > maxLength) {
                maxLength = line.length();
            }

            bob.append(line + "\n");
        }
        bob.append("\n");
        bob.append(
                StringUtils.repeat(" ",
                        (maxLength - letters.length * 2) / 2));

        for (Letter l : letters) {
            bob.append(l.isVisible() || l.getLetter().equals(" ") ? l.getLetter() : "_")
                    .append(" ");
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
