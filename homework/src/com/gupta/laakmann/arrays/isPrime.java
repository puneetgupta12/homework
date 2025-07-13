package com.gupta.laakmann.arrays;

import java.util.Scanner;

public class isPrime {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input your number.. upto 5.");
        int maxNumbers = 5;

        while (maxNumbers-- != 0) {
            int input = Integer.parseInt(scan.nextLine());
            System.out.println("The input number is prime? " + checkIfPrime(input));
        }
    }

    public static boolean checkIfPrime(int n) {
        if (n < 2) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(n);

        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
