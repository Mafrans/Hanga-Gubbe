package me.mafrans.hangman;

import java.util.Arrays;

public class WordGenerator {
    String[] cars = {"Källkod", "Array", "String", "Variabel", };
    public String[] generate() {
        return cars;
    }

    public static void main(String[] args) {
        WordGenerator wordGenerator = new WordGenerator();
        System.out.println(Arrays.toString(wordGenerator.generate()));
    }
}
