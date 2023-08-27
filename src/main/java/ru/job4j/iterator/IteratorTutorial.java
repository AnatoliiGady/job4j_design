package ru.job4j.iterator;

import java.awt.*;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class IteratorTutorial {
    public static void array(int[] num) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    joiner.add(Integer.toString(j));
                    System.out.println(joiner);
                }

            }

        }
    }

    //    joiner.add(Integer.toString(num[i]));

//System.out.println(joiner);


    public static void main(String[] args) {
        int[] array = {5, 5, 4, 3, 3, 1};
        array(array);
    }

}


