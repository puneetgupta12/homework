package com.gupta.java.personal.arrays;

import java.util.Arrays;

public class ConvertIntegerToArray {
    public static void main(String[] args) {
        int in = 12345;
        //int[] out = new int[findNumberOfDigits(in) + 1];
//        String inStr = String.valueOf(in);
//        int[] inArr = new int[inStr.length()];
//
//        for (int i = 0; i < inStr.length(); i ++) {
//            inArr[i] = Integer.parseInt(String.valueOf(inStr.charAt(i)));
//        }
//
//        Arrays.stream(inArr).forEach(n -> System.out.print(n + " "));

        convertIntoArray(in);
    }

    private static int findNumberOfDigits(int in) {
        if (in == 0) return 1;
        in = Math.abs(in);
        int len = 1;
        for (len = 0; in > 0; len++) {
            in /= 10;
        }
        System.out.println("Length of the number is: " + len);
        return len;
    }

    private static void convertIntoArray(int in) {
        int[] output = new int[10];
        in = Math.abs(in);
        int len;

        for (len = 0; in > 0; len++) {
            int mod = in % 10;
            in /= 10;
            output[len] = mod;
        }

        Arrays.stream(output).forEach(System.out::println);
    }
}
