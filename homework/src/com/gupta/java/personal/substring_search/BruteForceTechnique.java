package com.gupta.java.personal.substring_search;

import java.util.Locale;

//O(nm)
public class BruteForceTechnique {
    public static void main(String[] args) {
       String longText = "This test is the test test testtest";
       String shortText = "test";

       isSubstring(shortText, longText);
    }

    private static void isSubstring(String st, String lt) {
        char[] ltArr = lt.toLowerCase(Locale.ROOT).toCharArray();
        char[] stArr = st.toLowerCase(Locale.ROOT).toCharArray();
        int count = 0;

        for (int i = 0; i < ltArr.length; i++) {
            for (int j = 0; j < stArr.length; j++) {
                if (stArr[j] == ltArr[i]) {
                    if (j != stArr.length - 1) {
                        i++;
                        continue;
                    } else {
                        count++;
                        System.out.println("Match!");
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println("Matched " + count + " times");
    }
}
