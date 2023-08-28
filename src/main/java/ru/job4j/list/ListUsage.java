package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        List<String> list = rsl.subList(1, 2);
        for (String l : list) {
            System.out.println("Элемент: " + l);
        }
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
