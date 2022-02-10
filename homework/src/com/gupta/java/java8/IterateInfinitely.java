package com.gupta.java.java8;

import java.util.stream.IntStream;

public class IterateInfinitely {
    public static void main(String[] args) {
        IntStream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        //Iterate till number goes beyond 100 (CAUTION! filter(n -> n < 100) will go on in infinite loop
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        //Java 9 implementation of above, includes predicate in middle
        IntStream.iterate(0, n -> n < 100, n -> n + 4).forEach(System.out::println);

        //Generate infinite stream of 1s
        IntStream.generate(() -> 1).limit(10).forEach(System.out::print);
    }
}
