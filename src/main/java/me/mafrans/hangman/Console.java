package me.mafrans.hangman;

import org.fusesource.jansi.Ansi;

import java.io.IOException;

import static org.fusesource.jansi.Ansi.ansi;

public class Console {
    public static void log(Ansi ansi) {
        System.out.println(ansi.reset().toString());
    }

    public static void log(String string) {
        System.out.println(ansi().render(string));
    }

    public static void render(String string) {
        clear();
        log(ansi().eraseScreen().render(string).reset());
    }

    public static void render(Ansi ansi) {
        clear();
        log(ansi.eraseScreen().toString());
    }

    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
