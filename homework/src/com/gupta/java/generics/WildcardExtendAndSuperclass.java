package com.gupta.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
    The Get and Put Principle: use an extends wildcard when you only get values out of a structure,
    use a super wildcard when you only put values into a structure, and don’t use a wildcard when you both get and put.
 */
public class WildcardExtendAndSuperclass {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3);
        System.out.println(sum(ints));

        List<Double> doubles = Arrays.asList(2.78,3.14);
        System.out.println(sum(doubles));

        List<Long> longs = Arrays.asList(3L, 6L);
        System.out.println(sum(longs));

        List<Number> nums = Arrays.asList(1,2,2.78,3.14);
        System.out.println(sum(nums));

        // Add
        List<Integer> addInts = new ArrayList<Integer>();
        count(addInts, 5);
        addInts.stream().forEach(System.out::print);
        System.out.println();

        List<Number> addNums = new ArrayList<Number>();
        count(addNums, 9);
        addNums.stream().forEach(System.out::print);
        System.out.println();

        List<Object> addObjs = new ArrayList<Object>();
        count(addObjs, 7);
        addObjs.stream().forEach(System.out::print);
        System.out.println();
    }

    // ? extends Number means input type should be subclass of Number, such as, Integer or Double
    private static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number n : nums) s += n.doubleValue();
        return s;
    }

    // Whenever you use the add method, you put values into a structure, so use a super wildcard.
    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);
    }
}
