package me.mafrans.hangman;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Wordgenerator {
    private String[] wordlist;

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

    public String generate() {
        Random r = new Random();
        int randomNumber = r.nextInt(wordlist.length);

        return wordlist[randomNumber];
    }
}
