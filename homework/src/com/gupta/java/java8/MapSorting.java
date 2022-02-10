package com.gupta.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("tom", "max", "min", "mary", "dell", "hanks", "hobbes", "malcolm");

        //How many entries are of specific lengths?
        Map<Integer, Long> lengthMap = input.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        lengthMap.forEach((k,v) -> System.out.println(k + ":" + v));

        //Sort the map
        lengthMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        //Group by length
        Map<Integer, List<String>> groupedByMap = input.stream()
                .collect(Collectors.groupingBy(String::length));
        groupedByMap.forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
