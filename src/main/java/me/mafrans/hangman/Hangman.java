package me.mafrans.hangman;

public final class Hangman {
    private Hangman() {
    }

    private static final int MAX_FAILURES = 7;

    public static void main(final String[] args) {
        Wordgenerator wordgenerator = new Wordgenerator();
        HangmanManager manager = new HangmanManager(wordgenerator.generate());
        Input inputManager = new Input();

        manager.render();

        gameLoop:
        while (true) {
            Console.log("Skriv en bokstav mellan A och Z");
            String letter = inputManager.getLetter();

            if (letter == null) {
                Console.log("Den bokstaven kan du inte fråga efter.");
                manager.render();
                continue;
            }

            if (!manager.tryLetter(letter)) {
                Console.log("Aj aj aj, det var fel.");
            }

            if (manager.getFailures() == MAX_FAILURES) {
                manager.showAll();
                manager.render();

                while (true) {
                    Console.log("Game Over! Försök igen? (ja/nej)");
                    String input = inputManager.getInput();

                    if (input.equalsIgnoreCase("ja")) {
                        manager = new HangmanManager(wordgenerator.generate());
                        manager.render();
                        continue gameLoop;
                    } else if (input.equalsIgnoreCase("nej")) {
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
                    Console.log("Du vann, bra jobbat!");

                    while (true) {
                        Console.log("Vill du spela igen? (ja/nej)");
                        String input = inputManager.getInput();

                        if (input.equalsIgnoreCase("ja")) {
                            manager = new HangmanManager(
                                    wordgenerator.generate());

                            manager.render();
                            continue gameLoop;
                        } else if (input.equalsIgnoreCase("nej")) {
                            break gameLoop;
                        }
                    }
                }
            }
        }
    }
}
