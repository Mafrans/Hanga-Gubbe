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
        Wordgenerator wordgenerator = new Wordgenerator();
        HangmanManager manager = new HangmanManager(wordgenerator.generate());
        Input inputManager = new Input();

        manager.render();

        gameLoop:
        while (true) {
            Console.log("Type out a letter between A and Z.");
            String letter = inputManager.getLetter();

            if (letter == null) {
                Console.log("You cannot use this letter.");
                manager.render();
                continue;
            }

            if (!manager.tryLetter(letter)) {
                Console.log("Uh oh, that was incorrect.");
            }

            if (manager.getFailures() == MAX_FAILURES) {
                manager.showAll();
                manager.render();

                while (true) {
                    Console.log("Game Over! Try again? (yes/no)");
                    String input = inputManager.getInput();

                    if (input.equalsIgnoreCase("yes")) {
                        manager = new HangmanManager(wordgenerator.generate());
                        manager.render();
                        continue gameLoop;
                    } else if (input.equalsIgnoreCase("no")) {
                        break gameLoop;
                    }
                }
            } else {
                boolean allVisible = true;
                for (Letter l : manager.getLetters()) {
                    if (!l.isVisible()) {
                        allVisible = false;
                        break;
                    }
                }

                if (allVisible) {
                    Console.log("You won, great job!");

                    while (true) {
                        Console.log("Do you want to play again? (yes/no)");
                        String input = inputManager.getInput();

                        if (input.equalsIgnoreCase("yes")) {
                            manager = new HangmanManager(
                                    wordgenerator.generate());
                            manager.render();
                            continue gameLoop;
                        } else if (input.equalsIgnoreCase("no")) {
                            break gameLoop;
                        }
                    }
                }
            }
        }
    }
}
