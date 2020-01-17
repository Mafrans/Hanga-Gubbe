package me.mafrans.hangman;

public class HangmanRenderer {
    private Letter[] letters;

    public HangmanRenderer() {

    }

    public void showLetter(String letter) {
        for(Letter l : letters) {
            if (l.letter.equalsIgnoreCase(letter)) {
                l.visible = true;
            }
        }
    }
}
