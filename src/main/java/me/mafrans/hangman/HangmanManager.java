package me.mafrans.hangman;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;
import java.util.Scanner;

/**
 * <p>
 * Class managing the showing and hiding of letters,
 * as well as the UI rendering.
 * </p>
 *
 * @author Malte Klüft
 * @version 1.0
 * @since 1.0
 */
public class HangmanManager {
    /**
     * Array containing the current word's letters.
     */
    private Letter[] letters;

    /**
     * The amount of attempts the player has failed.
     */
    private int failures;

    /**
     * Constructor preparing a word for usage.
     *
     * @param word The word to prepare.
     */
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

    /**
     * Attempts to show a letter,
     * increases {@link #failures} if it fails to show any letter.
     *
     * @param letter The letter to try for
     * @return True if any letter in the current word was shown
     */
    public boolean tryLetter(final String letter) {
        boolean show = showLetter(letter);
        if (!show) {
            failures++;
        }
        render(failures);
        return show;
    }

    /**
     * Try to show a specific letter in the current word.
     *
     * @param letter The letter to show
     * @return True if any letter in the current word was shown
     */
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

    /**
     * Show all letters in the current word.
     */
    public void showAll() {
        for (Letter l : letters) {
            l.setVisible(true);
        }
    }

    /**
     * Render an ascii image representing the amount of failures inputted.
     * Also renders the current word, replacing any hidden letters with '_'.
     *
     * @param failures The amount of failures to render as
     */
    public void render(final int failures) {
        // Create a scanner and builder for reading a text file
        Scanner in = new Scanner(
                Objects.requireNonNull(
                        ClassLoader.getSystemResourceAsStream(
                                // The text file depends on the current amount of failures
                                "hangman-" + failures + ".txt")));
        StringBuilder bob = new StringBuilder();

        // Read the text file and save the length of the longest line
        int maxLength = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() > maxLength) {
                maxLength = line.length();
            }

            bob.append(line + "\n");
        }
        bob.append("\n");

        // Append a margin to the left, making sure the current word is centered
        bob.append(
                StringUtils.repeat(" ",
                        (maxLength - letters.length * 2) / 2));

        // Append the current word
        for (Letter l : letters) {
            bob.append(l.toString()).append(" ");
        }
        bob.append("\n");

        // Render the frame
        Console.render(bob.toString());
    }

    /**
     * Render an ascii image representing the current amount of failures.
     * Also renders the current word, replacing any hidden letters with '_'.
     */
    public void render() {
        render(failures);
    }

    /**
     * Get the current amount of failures.
     *
     * @return The current amount of failures
     */
    public int getFailures() {
        return failures;
    }

    /**
     * Get the current word, represented as an array of {@link Letter}s.
     *
     * @return The current word, represented as an array of {@link Letter}s
     */
    public Letter[] getLetters() {
        return letters;
    }
}
