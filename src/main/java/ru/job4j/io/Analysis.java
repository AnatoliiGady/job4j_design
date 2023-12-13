package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean serverOn = true;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             FileWriter fileWriter = new FileWriter(target)) {
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ", 2);
                if (serverOn && ("400".equals(words[0]) || "500".equals(words[0]))) {
                    fileWriter.write(words[1]);
                    fileWriter.write(";");
                    serverOn = false;
                }
                if (!serverOn && (words[0].equals("200") || words[0].equals("300"))) {
                    fileWriter.write(words[1]);
                    fileWriter.write(";");
                    fileWriter.write(System.lineSeparator());
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
