package me.mafrans.hangman.util.image;

import me.mafrans.hangman.util.Console;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.fusesource.jansi.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import static org.fusesource.jansi.Ansi.ansi;

public class AsciiArtGenerator {
    public static Ansi createFrom(String name) {
        return createFrom(getIncludedText(name), getIncludedImage(name));
    }

    public static Ansi createFrom(String text, Image image) {
        BufferedImage bi = (BufferedImage) image;
        Ansi ansi = ansi();
        String squared = squarify(text);

        int nextChar = 0;
        for (int y = 0; y < bi.getHeight(); y++) {
            for (int x = 0; x < bi.getWidth(); x++) {
                int clr = bi.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;

                AsciiColor color = AsciiColor.BLACK;
                for (AsciiColor c : AsciiColor.colors()) {
                    if(red == c.r && blue == c.b && green == c.g) {
                        color = c;
                        break;
                    }
                }

                Console.log(nextChar + " / " + (squared.length()));
                if(nextChar >= squared.length()) {
                    ansi.a(" ");
                    continue;
                }

                if(squared.charAt(nextChar) == '\n' || squared.charAt(nextChar) == '\r') { // Ignore new lines
                    while (squared.charAt(nextChar) == '\n' || squared.charAt(nextChar) == '\r') {
                        nextChar++;
                    }
                    ansi.a("\n");
                }

                if(color.isBright()) {
                    ansi.fgBright(color.getColor()).a(squared.charAt(nextChar));
                }
                else {
                    ansi.fg(color.getColor()).a(squared.charAt(nextChar));
                }

                nextChar++;
            }
        }
        return ansi.reset();
    }

    public static String squarify(String input) {
        String[] split = input.split("\n");
        int max = 0;
        for(String s : split) {
            if(s.length() > max) {
                max = s.length();
            }
        }

        String[] out = new String[split.length];
        for(int i = 0; i < out.length; i++) {
            StringBuilder sBuilder = new StringBuilder();

            while(sBuilder.length() < max) {
                sBuilder.append(" ");
            }

            out[i] = sBuilder.toString();
        }

        return StringUtils.join(out, "\n");
    }

    public static Image getIncludedImage(String name) {
        try {
            return ImageIO.read(ClassLoader.getSystemResourceAsStream("/resources/" + name + "/" + name + ".bmp"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getIncludedText(String name) {
        try {
            return IOUtils.resourceToString("/resources/" + name + "/" + name + ".txt", Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            return "null";
        }
    }

    public static void test() {
        Console.log(createFrom(getIncludedText("test"), getIncludedImage("test")));
    }
}
