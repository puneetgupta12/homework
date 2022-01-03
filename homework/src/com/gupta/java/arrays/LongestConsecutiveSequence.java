package com.gupta.java.arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};
        //int[] input = {12, -2, 101, 6, 100, -10, 102};

        //Arrays.stream(findLongestSequenceNaive(input)).forEach(System.out::println);

        findLongestSequenceBetter(input).stream().forEach(System.out::println);
    }

    private static int[] findLongestSequenceNaive(int[] input) {
        int[] out = new int[input.length];
        Arrays.sort(input); //O(nlogn))
        //Arrays.stream(input).forEach(System.out::println);

        for (int i=0; i<input.length; i++) {
            for (int j=i+1; j<input.length; j++) { //O(n2)
                if (input[j] == input[i] + 1) {
                    out[i] = input[i];
                    out[j] = input[j];
                    break;
                } else break;
            }
        }

        return out;
    }

    /*
        O(n): Because it requires O(n) complexity, we can not solve the problem by sorting the array first. Sorting takes at least O(nlogn) time.
        We can use a HashSet to add and remove elements. The add, remove and contains methods have constant time complexity O(1).
     */
    private static HashSet<Integer> findLongestSequenceBetter(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> out = new HashSet<>();
        for (int in: input) set.add(in);

        for (int num: input) {
            int down = num - 1;

            while (set.contains(down)) {
                out.add(down);
                set.remove(down);
                down--;
            }

            int up = num + 1;
            while(set.contains(up)) {
                out.add(up);
                set.remove(up);
                up++;
            }
        }

        return out;
    }
}
