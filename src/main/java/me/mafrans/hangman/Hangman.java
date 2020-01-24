package me.mafrans.hangman;

public class Hangman {
    public static void main(String[] args) {
        Wordgenerator wordgenerator = new Wordgenerator();
        HangmanRenderer renderer = new HangmanRenderer(wordgenerator.generate());
        renderer.render(5);
    }
}
