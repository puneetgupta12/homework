package com.gupta.java.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prime {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            InnerPrime ob = new InnerPrime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static class InnerPrime {
        public void checkPrime(int... num) {
            for (int i: num) {
                if (i == 1) {
                    continue;
                } else if (i == 2 || i == 3 || i == 5 || i == 7) {
                    System.out.print(i + " ");
                } else {
                    if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                        continue;
                    } else {
                        System.out.print(i + " ");
                    }
                }
            }
            System.out.println("");
        }

        //Better Solution
        boolean isPrime(int n) {
            if (n < 2) {
                return false;
            } else if (n == 2) {
                return true;
            } else if (n % 2 == 0) {
                return false;
            }
            int sqrt = (int) Math.sqrt(n);
            for (int i = 3; i <= sqrt; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
