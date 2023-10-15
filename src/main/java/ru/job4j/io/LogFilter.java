package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }
    public List<String> filter() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader((new FileReader(file)))) {
            in.lines().map(s -> s.split(" "))
                    .filter(strings -> strings[strings.length - 2].contains("404"))
                    .map(strings ->  String.join(" ", strings)).forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}