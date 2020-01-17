package me.mafrans.hangman.util;

import me.mafrans.consolegame.areas.Area;
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

    public static void render(String string, boolean wait) {
        clear();
        log(ansi().eraseScreen().render(string).reset());

        if(wait) waitForInput();
    }

    public static void render(Ansi ansi, boolean wait) {
        clear();
        log(ansi.eraseScreen().toString());

        if(wait) waitForInput();
    }

    public static void renderArea(Area area, boolean wait) {
        render(area.getDescription().toString(), wait);
    }

    public static void renderCurrent(boolean wait) {
        renderArea(App.self.areaHandler.currentArea, wait);
    }

    public static void waitForInput() {
        String input = App.self.in.next();
        App.self.areaHandler.currentArea.onCommand(input);
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
