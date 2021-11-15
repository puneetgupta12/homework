package com.gupta.laakmann.arrays;

import static java.lang.System.exit;

public class CheckPermutation {
    public static void main(String[] args) {
        String input = "madam";
        String matchTerm = "damma";

        checkPermutation("", input, matchTerm);
    }

    private static void checkPermutation(String candidate, String input, String matchTerm) {
        if (input == null) {
            return; //base case
        }

        if (input.length() == 0) {
            if (candidate.equals(matchTerm)) {
                System.out.println("Strings are permutations of each other.");
                System.exit(-1);
            }
        }

        for (int i=0; i<input.length(); i++) {
            String newCandidate = candidate + input.charAt(i);
            String newInput = input.substring(0,i) + input.substring(i+1);

            checkPermutation(newCandidate, newInput, matchTerm);
        }
    }
}
