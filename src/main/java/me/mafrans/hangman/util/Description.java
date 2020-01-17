package me.mafrans.hangman.util;

import java.util.HashMap;

public class Description {

    private String string;
    private HashMap<String, Object> params;

    public Description() {
        this.params = new HashMap<>();
    }

    public Description(String string) {
        this.string = string;
        this.params = new HashMap<>();
    }

    public Description(String string, HashMap<String, Object> params) {
        this.string = string;
        this.params = params;
    }

    public Description addParam(String key, Object value) {
        params.put(key, value);
        return this;
    }

    public Description removeParam(String key, Object value) {
        params.put(key, value);
        return this;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public Description setString(String string) {
        this.string = string;
        return this;
    }

    @Override
    public String toString() {
        String out = string;
        for(String key : params.keySet()) {
            string.replace("%" + key + "%", params.get(key).toString());
        }
        return out;
    }






    public static String HORIZONTAL_LINE = "\n----------------------------------------------------------------";
}
