package com.gupta.java.generics;

import java.util.ArrayList;
import java.util.List;

public class ConvertToList {
    public static void main(String[] args) {
        List<Integer> intList = toList(1, 2, 3, 4);
        List<String> stringList = toList("super", "man");

        intList.stream().forEach(System.out::print);
        System.out.println();
        stringList.stream().forEach(System.out::print);
        System.out.println();

        addAll(intList, 5, 6, 7, 8);
        intList.stream().forEach(System.out::print);
    }

    private static <T> List<T> toList(T... args) {
        List<T> list = new ArrayList<>();
        for (T e : args) list.add(e);
        return list;
    }

    private static <T> void addAll(List<T> list, T... args) {
        for (T e : args) list.add(e);
    }
}
