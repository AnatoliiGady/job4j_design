package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            out.write("Hello, world!".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(("2 * 2 = " + 2 * 2).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(("2 * 3 = " + 2 * 3).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(("4 * 3 = " + 4 * 3).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(("4 * 4 = " + 4 * 4).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(("10 * 2 = " + 10 * 2).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(("10 * 3 = " + 10 * 3).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
