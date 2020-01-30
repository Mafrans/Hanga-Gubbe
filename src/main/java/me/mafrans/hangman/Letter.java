package me.mafrans.hangman;

public class Letter {
    private String letter;
    private boolean visible;

    public Letter(final String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return visible || letter.equals(" ") ? letter : "_";
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
}
