package com.gupta.java.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
    How do you find the duplicate number in a given integer array?
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        // Numbers 5, 6, 7, 8, 9 are duplicates.
        int[] input = IntStream.concat(IntStream.range(0, 21), IntStream.range(5, 10)).toArray();
        //Arrays.stream(input).forEach(System.out::println);
        String[] out = findDuplicates(input);
        for (int j = 0; j < out.length; j++) {
            if (out[j] != null && out[j].equals("dup")) {
                System.out.println(j);
            }
        }

        int[] out2 = findDuplicatesUsingInt(input);
        for (int j = 0; j < out.length; j++) {
            if (out2[j] == 2) {
                System.out.println(j);
            }
        }
    }

    private static String[] findDuplicates(int[] input) {
        String[] counter = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            if (counter[input[i]] != null
                    && counter[input[i]].equals("in")) {
                counter[input[i]] = "dup";
            } else {
                counter[input[i]] = "in";
            }
        }

        return counter;
    }

    private static int[] findDuplicatesUsingInt(int[] input) {
        int[] counter = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            if (counter[input[i]] == 1) {
                counter[input[i]] = 2;
            } else {
                counter[input[i]] = 1;
            }
        }

        return counter;
    }
}
