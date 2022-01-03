package com.gupta.java.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequenceOfChars {
    public static void main(String[] args) {
        String input = "aegkbcdezxowl"; //Answer should be: abcde

        System.out.println(findSequence(input));
    }

    private static String findSequence(String input) {
        char[] inArr = input.toCharArray();
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> out = new HashSet<>();
        for (char c: inArr) {
            set.add(Character.valueOf(c));
        }

        for (char c : inArr) {
            char down = previousChar(c);
            Character downCharacter = Character.valueOf(down);
            while (set.contains(downCharacter)) {
                out.add(downCharacter);
                set.remove(downCharacter);
                downCharacter = Character.valueOf(previousChar(down));
            }

            char up = nextChar(c);
            Character upCharacter = Character.valueOf(up);
            while (set.contains(upCharacter)) {
                out.add(upCharacter);
                set.remove(upCharacter);
                upCharacter = Character.valueOf(nextChar(down));
            }
        }

        StringBuilder sb = new StringBuilder();
        out.stream().forEach(s -> sb.append(s));
        return sb.toString();
    }

    private static char previousChar(char c) {
        return (char)((int) c - 1);
    }

    private static char nextChar(char c) {
        return (char)((int) c + 1);
    }
}
