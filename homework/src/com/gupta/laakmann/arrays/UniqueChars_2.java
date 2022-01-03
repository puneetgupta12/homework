package com.gupta.laakmann.arrays;

import java.util.HashMap;
import java.util.Map;

public class UniqueChars_2 {
    public static void main(String[] args) {
        //String[] input = new String[]{"This is the time for all good men to come to the aid of their country."};
        String input = "This is the time for all good men to come to the aid of their country.";
        //String input = "ader%^$^@# st*(#$77";
        String sanitized = sanitizeInput(input);
        if (isUnique(sanitized)) {
            System.out.println("chars in string are unique.");
        } else {
            System.out.println("chars in string are not unique.");
        }
    }

    private static String sanitizeInput(String input) {
        return input.replaceAll("[^a-zA-Z]+", "").toLowerCase().trim();
    }

    private static boolean isUnique(String input) {
        boolean[] check = new boolean[128];

        for (int i=0; i<input.length(); i++) {
            if (check[input.charAt(i)] == true) {
                return false;
            }
            check[input.charAt(i)] = true;
        }

        return true;
    }
}
