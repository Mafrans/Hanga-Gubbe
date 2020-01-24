package me.mafrans.hangman;

import java.awt.*;
import java.util.Scanner;

public class HangmanRenderer {
    private Letter[] letters;
    private boolean[] visible;

    public HangmanRenderer(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) { // Loop over every letter in the word
            String ch = String.valueOf(word.charAt(i));
            Letter letter = new Letter(ch);

            letter.visible = false;
            letters[i] = letter;
        }
    }

    public void showLetter(String letter) {
        for(Letter l : letters) {
            if (l.letter.equalsIgnoreCase(letter)) {
                l.visible = true;
            }
        }
    }

    public void render(int failures) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("hangman-" + failures + ".txt"));
        StringBuilder bob = new StringBuilder();
        while(in.hasNextLine()) {
            bob.append(in.nextLine() + "\n");
        }
        Console.render(bob.toString());
    }
}
