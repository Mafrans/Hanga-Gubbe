package me.mafrans.hangman;

public class Hangman {
    public static void main(String[] args) {
        Wordgenerator wordgenerator = new Wordgenerator();
        for (int i = 0; i < 100; i++) {
            System.out.println(wordgenerator.generate());
        }
    }
}
