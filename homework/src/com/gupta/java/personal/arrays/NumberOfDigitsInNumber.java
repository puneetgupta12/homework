package com.gupta.java.personal.arrays;

public class NumberOfDigitsInNumber {
    public static void main(String[] args) {
        int n = 12345678; //8 digit number

        System.out.println(numberOfDigits(n));
    }

    public static int numberOfDigits(int n) {
        if (n == 0) return 1;
        int len = 1;
        n = Math.abs(n); //Take +ve outlook
        for (len=0; n>0; len++) {
            n /= 10;
        }

        return len;
    }
}
