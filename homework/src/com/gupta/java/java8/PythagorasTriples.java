package com.gupta.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PythagorasTriples {
    public static void main(String[] args) {
        List<int[]> ptriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a*a + b*b)})
                ).collect(Collectors.toList());

        ptriples.stream().limit(10).forEach(r -> System.out.println(Arrays.toString(r)));
    }
}
