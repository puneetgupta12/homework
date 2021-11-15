package com.gupta.laakmann.arrays;

import java.util.Locale;

public class PalindromePermutation {
    public static void main(String[] args) {
        String input = "Tact Coa";

        permutations("", input.toLowerCase());
    }

    private static void permutations(String candidate, String remaining) {

        //Base case
        if (remaining == null) {
            return;
        }

        if (remaining.length() == 0) {
            //System.out.println(candidate);

            if (checkPalindrome(candidate)) {
                System.out.println("Word " + candidate + " is a palindrome.");
            }
        }

        for (int i=0; i<remaining.length(); i++) {
            String newCandidate = candidate + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            permutations(newCandidate, newRemaining);
        }
    }

    private static boolean checkPalindrome(String incoming) {
        int j = incoming.length() - 1;
        char[] inArray = incoming.toCharArray();
        for (int i=0; i<inArray.length; i++) {
            if (inArray[i] == ' ') {
                i = i + 1;
            }

            if (j>0 && inArray[j] == ' ') {
                j = j - 1;
            }

            if (j>0 && inArray[i] != inArray[j]) {
                return false;
            }
            j--;
        }

        return true;
    }
}
