package me.mafrans.hangman.util.image;

import org.fusesource.jansi.Ansi;

public class AsciiColor {
    public int r;
    public int g;
    public int b;
    private Ansi.Color color;
    private boolean bright;

    public AsciiColor(int r, int g, int b, Ansi.Color color, boolean bright) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.color = color;
        this.bright = bright;
    }

    public Ansi.Color getColor() {
        return color;
    }

    public boolean isBright() {
        return bright;
    }


    public static AsciiColor BLACK = new AsciiColor(0, 0, 0, Ansi.Color.BLACK, false);
    public static AsciiColor RED = new AsciiColor(128, 0, 0, Ansi.Color.RED, false);
    public static AsciiColor GREEN = new AsciiColor(0, 128, 0, Ansi.Color.GREEN, false);
    public static AsciiColor YELLOW = new AsciiColor(128, 128, 0, Ansi.Color.YELLOW, false);
    public static AsciiColor BLUE = new AsciiColor(0, 0, 128, Ansi.Color.BLUE, false);
    public static AsciiColor MAGENTA = new AsciiColor(128, 0, 128, Ansi.Color.MAGENTA, false);
    public static AsciiColor CYAN = new AsciiColor(0, 128, 128, Ansi.Color.CYAN, false);
    public static AsciiColor WHITE = new AsciiColor(192, 192, 192, Ansi.Color.WHITE, false);

    public static AsciiColor BRIGHT_BLACK = new AsciiColor(128, 128, 128, Ansi.Color.BLACK, true);
    public static AsciiColor BRIGHT_RED = new AsciiColor(255, 0, 0, Ansi.Color.RED, true);
    public static AsciiColor BRIGHT_GREEN = new AsciiColor(0, 255, 0, Ansi.Color.GREEN, true);
    public static AsciiColor BRIGHT_YELLOW = new AsciiColor(255, 255, 0, Ansi.Color.YELLOW, true);
    public static AsciiColor BRIGHT_BLUE = new AsciiColor(0, 0, 255, Ansi.Color.BLUE, true);
    public static AsciiColor BRIGHT_MAGENTA = new AsciiColor(255, 0, 255, Ansi.Color.MAGENTA, true);
    public static AsciiColor BRIGHT_CYAN = new AsciiColor(0, 255, 255, Ansi.Color.CYAN, true);
    public static AsciiColor BRIGHT_WHITE = new AsciiColor(255, 255, 255, Ansi.Color.WHITE, true);

    public static AsciiColor[] colors() {
        return new AsciiColor[]{
                BLACK,
                RED,
                GREEN,
                YELLOW,
                BLUE,
                MAGENTA,
                CYAN,
                WHITE,

                BRIGHT_BLACK,
                BRIGHT_RED,
                BRIGHT_GREEN,
                BRIGHT_YELLOW,
                BRIGHT_BLUE,
                BRIGHT_MAGENTA,
                BRIGHT_CYAN,
                BRIGHT_WHITE
        };
    }
}
