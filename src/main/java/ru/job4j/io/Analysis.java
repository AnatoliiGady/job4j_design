package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean serverOn = true;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             FileOutputStream outputStream = new FileOutputStream(target)) {
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ", 2);
                if (serverOn && (words[0].equals("400") || words[0].equals("500"))) {
                    outputStream.write(words[1].getBytes());
                    outputStream.write(";".getBytes());
                    serverOn = false;
                }
                if (!serverOn && (words[0].equals("200") || words[0].equals("300"))) {
                    outputStream.write(words[1].getBytes());
                    outputStream.write(";".getBytes());
                    outputStream.write(System.lineSeparator().getBytes());
                    serverOn = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
