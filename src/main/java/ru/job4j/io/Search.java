package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {
    public static void main(String[] args) throws IOException {
        validParameter(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);

    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validParameter(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("incorrect number of arguments");
        }
        File file = new File(args[0]);
        Pattern pattern = Pattern.compile("^.[a-zA-Z]+");
        if (!file.exists()) {
            throw new IllegalArgumentException("root folder should not be null");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("search extension is empty, enter file extension");
        }
        if (!args[1].matches("^.[a-zA-Z]+")) {
            throw new IllegalArgumentException("the second argument must begin with \".\" and have more characters");
        }
    }
}
