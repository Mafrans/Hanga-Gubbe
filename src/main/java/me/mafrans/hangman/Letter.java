package me.mafrans.hangman;

/**
 * <p>
 * Object containing a single letter and a
 * boolean determining its visibility.
 * </p>
 *
 * @since 1.0
 * @author Malte Klüft
 * @version 1.0
 */
public class Letter {
    /**
     * Letter string.
     */
    private String letter;

    /**
     * Boolean determining whether the letter should be visible or not.
     */
    private boolean visible;

    /**
     * Instantiates a new {@link Letter} from an input string.
     * @param letter The input string.
     */
    public Letter(final String letter) {
        this.letter = letter;
    }

    /**
     * Returns the letter string if it is
     * visible or equal to ' ', otherwise returns '_'.
     *
     * @return The letter string if it is
     * visible or equal to ' ', otherwise returns '_'
     */
    @Override
    public String toString() {
        return visible || letter.equals(" ") ? letter : "_";
    }

    /**
     * Get the letter string.
     * @return The letter string
     */
    public String getLetter() {
        return letter;
    }

    /**
     * Set the letter string.
     * @param letter The new letter string
     */
    public void setLetter(final String letter) {
        this.letter = letter;
    }

    /**
     * Get the current visibility.
     * @return True if the letter is visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Set the current visibility.
     * @param visible The new visibility
     */
    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
}
