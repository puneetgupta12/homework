package com.gupta.java.personal.arrays;

public class NumberOfDigitsInNumber {
    public static void main(String[] args) {
        int n = 100204569; //8 digit number

        System.out.println(numberOfDigits(n));
    }

    public static int numberOfDigits(int n) {
        if (n == 0) return 1;
        int len;
        n = Math.abs(n); //Take +ve outlook
        for (len=0; n>0; len++) {
            n /= 10;
        }

        return len;
    }
}
