package com.gupta.java.java8;

import java.util.stream.Stream;

public class FibonacciUsingStream {
    public static void main(String[] args) {
        // Print in tuples (0,1) (1,1) (1,2) etc.
        Stream.iterate(new int[] {0, 1},
                t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .forEach(r -> System.out.println("(" + r[0] + "," + r[1] + ")"));

        //Print in normal style
        Stream.iterate(new int[] {0, 1},
                t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(r -> System.out.print(r + ", "));
    }
}
