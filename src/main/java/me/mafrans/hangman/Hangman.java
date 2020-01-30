package me.mafrans.hangman;

/**
 * <p>
 * Main class running the entire game process.
 * </p>
 *
 * @since 1.0
 * @author Malte Klüft, Filip Norberg
 * @version 1.0
 */
public final class Hangman {
    private Hangman() {
    }

    /**
     * The amount of failures required to lose the game.
     */
    private static final int MAX_FAILURES = 7;

    /**
     * The main process, handles the game loop.
     * @param args Array of process arguments (unused)
     */

    public static void main(final String[] args) {
        // Instantiate the utility objects used by the main class
        Wordgenerator wordgenerator = new Wordgenerator();
        Input inputManager = new Input();

        // Instantiate the main hangman manager object
        HangmanManager manager = new HangmanManager(wordgenerator.generate());

        // Render the first frame
        manager.render();

        // Primary game loop, will not end until the player shuts the game down.
        gameLoop:
        while (true) {
            // Get a letter
            Console.log("Type out a letter between A and Z.");
            String letter = inputManager.getLetter();

            if (letter == null) {
                Console.log("You cannot use this letter.");
                manager.render();
                continue;
            }

            // The letter was incorrect
            if (!manager.tryLetter(letter)) {
                Console.log("Uh oh, that was incorrect.");
            }

            // The player has lost the game
            if (manager.getFailures() == MAX_FAILURES) {
                manager.showAll();
                manager.render();

                // Secondary loop asking the player if they want to try again
                // Only ends if they answer 'yes' or 'no'
                while (true) {
                    Console.log("Game Over! Try again? (yes/no)");
                    String input = inputManager.getInput();

                    if (input.equalsIgnoreCase("yes")) {
                        // Create a new hangman renderer and restart the game
                        manager = new HangmanManager(wordgenerator.generate());
                        manager.render();
                        continue gameLoop;
                    } else if (input.equalsIgnoreCase("no")) {
                        // Quit the game
                        break gameLoop;
                    }
                }
            } else { // The player still hasn't lost yet
                boolean allVisible = true;
                for (Letter l : manager.getLetters()) {
                    if (!l.isVisible()) {
                        // If any one letter is still hidden, allVisible is equal to false
                        // Otherwise it stays equal to true
                        allVisible = false;
                        break;
                    }
                }

                // The player has uncovered every single letter
                if (allVisible) {
                    Console.log("You won, great job!");

                    // Secondary loop asking the player if they want to play again
                    // Only ends if they answer 'yes' or 'no'
                    while (true) {
                        Console.log("Do you want to play again? (yes/no)");
                        String input = inputManager.getInput();

                        if (input.equalsIgnoreCase("yes")) {
                            // Create a new manager and restart the game
                            manager = new HangmanManager(
                                    wordgenerator.generate());
                            manager.render();
                            continue gameLoop;
                        } else if (input.equalsIgnoreCase("no")) {
                            // Quit the game
                            break gameLoop;
                        }
                    }
                }
            }
        }
    }
}
