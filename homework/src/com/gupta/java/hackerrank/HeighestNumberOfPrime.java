package com.gupta.java.hackerrank;

public class HeighestNumberOfPrime {
    public static void main(String[] args) {
        long num = 123456;
        System.out.println("number of digits: " + getDigits(num));
    }

    private static int getDigits(long num) {
        return (int) Math.log10(num) + 1;
    }
}
