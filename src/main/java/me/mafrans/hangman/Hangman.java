package me.mafrans.hangman;

public class Hangman {
    public static void main(String[] args) {
        Wordgenerator wordgenerator = new Wordgenerator();
        HangmanManager renderer = new HangmanManager(wordgenerator.generate());
        renderer.render(5);
    }
}
