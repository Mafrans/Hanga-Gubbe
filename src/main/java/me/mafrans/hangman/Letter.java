package me.mafrans.hangman;

public class Letter {
    public String letter;
    public boolean visible;

    public Letter(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return visible ? letter : "";
    }
}
