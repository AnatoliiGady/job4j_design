package ru.job4j.generics;

import java.util.*;

public class GenericsUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        for (String line : list) {
            System.out.println("Текущий элемент: " + line);
        }
        System.out.println("////////////////////////////");

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        new GenericsUsage().printRsl(list1);

        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericsUsage().printInfo(per);
        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericsUsage().printInfo(pro);
        List<? super Integer> list2 = new ArrayList<>();
        new GenericsUsage().addAll(list2);
    }

    public void printRsl(Collection<?> col) {
        for (Iterator<?> iterator = col.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
        System.out.println("////////////////////////////");
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> iterator = col.iterator(); iterator.hasNext();) {
            Person next = iterator.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        System.out.println("////////////////////////////");
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object line : list) {
            System.out.println("Текущий элемент: " + line);

        }
    }
}
