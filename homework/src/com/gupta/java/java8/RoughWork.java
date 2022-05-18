package com.gupta.java.java8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoughWork {
    public static void main(String[] args) {

        //Print every 3rd element
        int[] input = {0, 1, 2, 4, -99, 100, 120, 1432};
        int chunkSize = 3;
        IntStream.iterate(0, i -> i + chunkSize)
                .limit((long) Math.ceil((double) input.length / chunkSize))
                .forEach(o -> System.out.println(input[o]));

        //Join 2 arrays
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};

        IntStream joinedArrays = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2));
        joinedArrays.forEach(System.out::println);
    }
}
