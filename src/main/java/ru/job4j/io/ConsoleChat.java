package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> listAnswers = this.readPhrases();
        List<String> listLog = new ArrayList<>();
        String botAnswer;
        Scanner scanner = new Scanner(System.in);
        int listAnswersSize = listAnswers.size();
        String userAnswer = CONTINUE;
        out:
        while (!OUT.equals(userAnswer)) {
            if (CONTINUE.equals(userAnswer)) {
                while (!STOP.equals(userAnswer)) {
                    botAnswer = listAnswers.get((int) (Math.random() * listAnswersSize));
                    listLog.add(botAnswer);
                    System.out.println(botAnswer);
                    userAnswer = scanner.nextLine();
                    listLog.add(userAnswer);
                    if (OUT.equals(userAnswer)) {
                        break out;
                    }
                }
            }
            userAnswer = scanner.nextLine();
            listLog.add(userAnswer);
        }
        saveLog(listLog);
    }

    private List<String> readPhrases() {
        Path botAnswers = Paths.get("data/" + this.botAnswers);
        if (!botAnswers.toFile().exists()) {
            throw new IllegalArgumentException(String.format("File '%s' in not exists", this.botAnswers));
        }
        List<String> listAnswers = new ArrayList<>();
        try (BufferedReader readerFile = new BufferedReader(
                new FileReader(botAnswers.toString(), StandardCharsets.UTF_8))) {
            listAnswers = readerFile.lines().toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAnswers;
    }

    private void saveLog(List<String> log) {
        Path path = Paths.get("data/" + this.path);
        path.toFile().delete();
        try (PrintWriter writerLog = new PrintWriter(
                new FileWriter(path.toString(), StandardCharsets.UTF_8, true))) {
            log.forEach(writerLog::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("botLog.txt", "botAnswers.txt");
        consoleChat.run();
    }
}
