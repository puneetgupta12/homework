package com.gupta.laakmann.arrays;

import java.util.ArrayList;
import java.util.List;

/*
One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
 */
public class OneWay {
    public static void main(String[] args) {
        String one = "pale";
        String two = "ple";

        //Find all r=3 combinations of the string one
        isOneWay(one, two, two.length());
        isOneWay("pales", "pale", two.length());
        isOneWay("pale", "bale", two.length());
        isOneWay("pale", "bake", two.length());
    }

    private static void isOneWay(String one, String two, int r) {
        List<String> sourceCombinations = new ArrayList<>();
        boolean found = false;
        char[] sourceData = new char[r];
        ChecknCrCombinations.combination(sourceCombinations, one.toCharArray(), sourceData, 0, one.toCharArray().length - 1, 0, r);

        //sourceCombinations.forEach(System.out::println);

        List<String> targetCombinations = new ArrayList<>();
        char[] targetData = new char[r];
        ChecknCrCombinations.combination(targetCombinations, two.toCharArray(), targetData, 0, two.toCharArray().length - 1, 0, r);

        //targetCombinations.forEach(System.out::println);

        System.out.println();

        for (String s : sourceCombinations) {
            for (String t : targetCombinations) {
                if (s.contains(t)) {
                    found = true;
                    System.out.print(one + " -> " + two + " true");
                    break;
                }
            }

            if (found) break;
        }

        if (!found) {
            System.out.print(one + " -> " + two + " false");
        }
    }
}
