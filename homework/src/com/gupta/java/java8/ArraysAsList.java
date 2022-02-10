package com.gupta.java.java8;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Rachel", "Sita");

        input.set(0, "Gita"); //Replace Rachel with Gita
        try {
            input.add("Ram"); //We cannot do this, will throw UnsupportedOperationException
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
        }
        input.forEach(System.out::println);
    }
}
