package com.gupta.java.personal.arrays;

/*
    How do you find all pairs of an integer array whose sum is equal to a given number?
 */
public class PairsSum {
    public static void main(String[] args) {
        int target = 10;
        int[] in = {-5, 0, -30, 45, 15, 2, 4, 10};

        for (int i = 0; i < in.length; i++) {
            for (int j = 1; j < in.length; j++) {
                if (in[i] + in[j] == target) {
                    System.out.println("Pairs are: " + in[i] + " and " + in[j]);
                }
            }
        }
    }
}
