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
        /*List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(2, list);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
        System.out.println("//---------------------------//");
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент: " + rsl.get(i));
        }
        System.out.println("//--------------------------//");
        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }
        System.out.println("//-------------------------//");
        ListIterator<String> iterator1 = rsl.listIterator();
        while (iterator1.hasNext()) {
            System.out.println("Текущий элемент: " + iterator1.next());
        }
        System.out.println("//------------------------//");
        ListIterator<String> iterator2 = rsl.listIterator(2);
        while (iterator2.hasNext()) {
            System.out.println("Текущий элемент: " + iterator2.next());
        }
        System.out.println("//----------------------//");
        rsl.set(1, "two and second");
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
        System.out.println("//----------------------//");
        rsl.replaceAll(String::toUpperCase);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
        System.out.println("//---------------------//");*/
        //List<String> list = new ArrayList<>();
        //list.add("one");
        //list.add("two");
        //rsl.removeAll(list1);
        //rsl.retainAll(list);
        //rsl.removeIf(s -> s.length() <= 3);
        //boolean b = rsl.contains("one");
        //System.out.println(b);
        List<String> list = rsl.subList(1, 2);
        for (String l : list) {
            System.out.println("Элемент: " + l);
        }
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
