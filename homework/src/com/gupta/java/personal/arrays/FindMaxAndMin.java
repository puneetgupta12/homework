package com.gupta.java.personal.arrays;

/*
    How do you find the largest and smallest number in an unsorted integer array?
 */
public class FindMaxAndMin {
    public static void main(String[] args) {
        int[] in = {-3, 0, 1, 3, 10, 5, -6, 9, 99};

        System.out.println("Largest number is: " + findMax(in));
        System.out.println("Smallest number is: " + findMin(in));
    }

    private static int findMax(int[] in) {
        int max = 0;

        for (int i = 0; i < in.length; i++) {
            if (in[i] > max) {
                max = in[i];
            }
        }

        return max;
    }

    private static int findMin(int[] in) {
        int min = 0;

        for (int i = 0; i < in.length; i++) {
            if (in[i] < min) {
                min = in[i];
            }
        }

        return min;
    }
}
