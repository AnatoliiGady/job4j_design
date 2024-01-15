package ru.job4j.io;

import java.util.Arrays;
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
        for (String arg : args) {
            validationArguments(arg);
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public void parse(String[] args) {
        Arrays.stream(args)
                .map(s -> s.substring(1))
                .map(s -> s.split("=", 2))
                .forEach(arr -> values.put(arr[0], arr[1]));
    }

    private static void validationArguments(String args) {
        if (!args.contains("=")) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", args));
        }
        if (!Character.toString(args.charAt(0)).equals("-")) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", args));
        }
        String[] keyAndValueArr = args.substring(1).split("=", 2);
        if (keyAndValueArr[0].isEmpty()) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", args));
        }
        if (keyAndValueArr[1].isEmpty()) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", args));
        }
    }


    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
