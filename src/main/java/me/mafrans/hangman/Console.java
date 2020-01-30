package me.mafrans.hangman;

import org.fusesource.jansi.Ansi;

import java.io.IOException;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * <p>
 * Utility class responsible for outputting
 * information into the command line console.
 * </p>
 *
 * @since 1.0
 * @author Malte Klüft
 * @version 1.0
 */
public final class Console {
    private Console() {
    }

    /**
     * Log a colored JAnsi string to the console.
     * @param ansi The JAnsi string to be logged
     */
    public static void log(final Ansi ansi) {
        System.out.println(ansi.reset().toString());
    }

    /**
     * Log a string to the console.
     * @param string The string to be logged
     */
    public static void log(final String string) {
        System.out.println(ansi().render(string));
    }

    /**
     * Clear the command line window, then log a string.
     * @param string The string to be logged
     */
    public static void render(final String string) {
        clear();
        log(ansi().eraseScreen().render(string).reset());
    }

    /**
     * Clear the command line window, then log a JAnsi string.
     * @param ansi The string to be logged
     */
    public static void render(final Ansi ansi) {
        clear();
        log(ansi.eraseScreen().toString());
    }

    /**
     * Clear the entire command line window using a process builder.
     */
    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
