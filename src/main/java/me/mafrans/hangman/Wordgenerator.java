package me.mafrans.hangman;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Wordgenerator {
    private String[] wordlist;

    /**
     * Creates an instance of Wordgenerator and caches all available words.
     */
    public Wordgenerator() {
        Scanner scanner = new Scanner(
                Objects.requireNonNull(
                        ClassLoader.getSystemResourceAsStream("wordlist.csv")));

        Set<String> wordlist = new HashSet<String>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            wordlist.add(line.split(",")[0]);
        }

        this.wordlist = wordlist.toArray(new String[0]);
    }

    /**
     * Generates a random word from the wordlist.
     * @return Returns the generated word.
     */
    public String generate() {
        Random r = new Random();
        int randomNumber = r.nextInt(wordlist.length);

        return wordlist[randomNumber];
    }
}
