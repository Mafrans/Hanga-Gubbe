package me.mafrans.hangman;

import org.fusesource.jansi.Ansi;

import java.io.IOException;

import static org.fusesource.jansi.Ansi.ansi;

public final class Console {
    private Console() {
    }

    public static void log(final Ansi ansi) {
        System.out.println(ansi.reset().toString());
    }

    public static void log(final String string) {
        System.out.println(ansi().render(string));
    }

    public static void render(final String string) {
        clear();
        log(ansi().eraseScreen().render(string).reset());
    }

    public static void render(final Ansi ansi) {
        clear();
        log(ansi.eraseScreen().toString());
    }

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
