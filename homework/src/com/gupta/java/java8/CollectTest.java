package com.gupta.java.java8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectTest {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Banana", "Apple", "Guava", "Berries");

        //Remove duplicates
        Set<String> fruitsWithoutDuplicates = fruits.stream().collect(Collectors.toSet());

        //Group by to find number of each fruit in the list
        Map<String, List<String>> grouped = fruits.stream().collect(Collectors.groupingBy(f -> f));
        grouped.forEach((k,v) -> System.out.println(k + ": " + v.size()));
    }
}
