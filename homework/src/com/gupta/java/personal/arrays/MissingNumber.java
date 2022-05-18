package com.gupta.java.personal.arrays;

import java.util.stream.IntStream;

/*
    How do you find the missing number in a given integer array of 1 to 100?
 */
public class MissingNumber {
    public static void main(String[] args) {
        // Number 54 is missing from the below list
        int[] input = IntStream.concat(IntStream.range(1, 54), IntStream.range(55, 101)).toArray();
        //Arrays.stream(input).forEach(System.out::println);
        System.out.println("The missing number is: " + findMissingNumber(input));
    }

    private static int findMissingNumber(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != input[i + 1] - 1) {
                return input[i + 1] - 1;
            }
        }

        return -1;
    }
}
