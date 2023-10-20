package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(s -> !s.isBlank() && !s.startsWith("#"))
                    .map(s -> s.split("=", 2))
                    .forEach(pair -> {
                        if (pair.length == 1 || pair[0].isEmpty() || pair[1].isEmpty()) {
                            throw new IllegalArgumentException();
                        }

                        values.put(pair[0], pair[1]);
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);

    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("data/app.properties");
        config.load();
        for (Map.Entry<String, String> entry : config.values.entrySet()) {
            System.out.println("Ключ " + entry.getKey() + " значение " + entry.getValue());
        }
    }
}
