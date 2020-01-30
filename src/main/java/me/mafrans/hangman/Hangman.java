package me.mafrans.hangman;

public class Hangman {
    public static void main(String[] args) {
        Wordgenerator wordgenerator = new Wordgenerator();
        HangmanManager manager = new HangmanManager(wordgenerator.generate());
        Input inputManager = new Input();

        manager.render();

        gameLoop: while (true) {
            Console.log("Type out a letter between A and Z.");
            String letter = inputManager.getLetter();

            if(letter == null) {
                Console.log("You cannot use this letter.");
                manager.render();
                continue;
            }

            if(!manager.tryLetter(letter)) {
                Console.log("Uh oh, that was incorrect.");
            }

            if(manager.getFailures() == 7) {
                manager.showAll();
                manager.render();

                while (true) {
                    Console.log("Game Over! Try again? (yes/no)");
                    String input = inputManager.getInput();

                    if (input.equalsIgnoreCase("yes")) {
                        manager = new HangmanManager(wordgenerator.generate());
                        manager.render();
                        continue gameLoop;
                    }
                    else if (input.equalsIgnoreCase("no")) {
                        break gameLoop;
                    }
                }
            }
            else {
                boolean allVisible = true;
                for(Letter l : manager.getLetters()) {
                    if (!l.visible) {
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
                            manager = new HangmanManager(wordgenerator.generate());
                            manager.render();
                            continue gameLoop;
                        }
                        else if (input.equalsIgnoreCase("no")) {
                            break gameLoop;
                        }
                    }
                }
            }
        }
    }
}
