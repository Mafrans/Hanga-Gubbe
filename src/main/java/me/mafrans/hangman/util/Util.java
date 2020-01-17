package me.mafrans.hangman.util;

import org.apache.commons.lang3.ArrayUtils;

public class Util {
    public static String getCommand(String input) {
        return input.split(" ")[0];
    }

    public static String[] getArgs(String input) {
        String[] split = input.split(" ");
        if(split.length < 2) {
            return new String[0];
        }
        else {
            return ArrayUtils.subarray(split, 1, split.length);
        }
    }
}
