package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public void parse(String[] args) {
        for (String line : args) {
            if (!line.contains("=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", args[1]));
            }
            if (!Character.toString(line.charAt(0)).equals("-")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", args[1]));
            }
            String key = line.substring(line.indexOf("-") + 1, line.indexOf("="));
            String value = line.substring(line.indexOf("=") + 1);
            if (key.isBlank()) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", args[1]));
            }
            if (value.isBlank()) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", args[1]));
            }
            values.put(key, value);
        }
    }


    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
