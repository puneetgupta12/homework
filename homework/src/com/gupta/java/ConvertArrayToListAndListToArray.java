package com.gupta.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertArrayToListAndListToArray {
    public static void main(String[] args) {
        //Method 1
        String[] input = new String[]{"Are", "you", "ready?"};

        //Convert to list
        List<String> list = new ArrayList<>(Arrays.asList(input));
        list.forEach(System.out::println);

        //Method 2
        String[] input2 = {"Are", "you", "ready?"};
        //Convert to list
        List<String> input2list = Arrays.stream(input2).collect(Collectors.toList());
        input2list.forEach(System.out::println);

        List<String> list1 = new ArrayList<>();
        list1.add("another");
        list1.add("example");
        list1.add("of arrays");

        //Convert to array
        String[] output = list1.toArray(new String[0]);
        Arrays.stream(output).forEach(System.out::println);

        //Method 2
        String[] output1 = list1.stream().toArray(String[]::new);
        Arrays.stream(output1).forEach(System.out::println);
    }
}
