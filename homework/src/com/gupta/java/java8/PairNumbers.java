package com.gupta.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and a list [3, 4]
    you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.
 */
public class PairNumbers {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<int[]> out = new ArrayList<>();

        int[] arr1 = list1.stream().mapToInt(i -> i).toArray();
        int[] arr2 = list2.stream().mapToInt(i -> i).toArray();

        //Method 1
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                out.add(new int[] {arr1[i], arr2[j]});
            }
        }
        //out.stream().forEach(o -> System.out.println(Arrays.toString(o)));

        //Method 2 - Java8
        List<int[]> pairs = list1.stream().flatMap(i -> list2.stream().map(j -> new int[] {i,j})).collect(Collectors.toList());
        pairs.stream().forEach(p -> System.out.println(Arrays.toString(p)));
    }
}
