package com.gupta.laakmann.arrays;

import java.util.HashMap;
import java.util.Map;

public class UniqueChars {
    public static void main(String[] args) {
        //String[] input = new String[]{"This is the time for all good men to come to the aid of their country."};
        String input = "This is the time for all good men to come to the aid of their country.";
        //String input = "ader%^$^@# st*(#$77";
        char[] sanitized = sanitizeInput(input);
        findUsingMaps(sanitized);
        findWithoutUsingMaps(sanitized);
    }

    private static char[] sanitizeInput(String input) {
        String sanitized = input.replaceAll("[^a-zA-Z]+", "").toLowerCase().trim();
        return sanitized.toCharArray();
    }

    private static void findUsingMaps(char[] input) {
        Map<Character, Integer> count = new HashMap<>();
        boolean isUnique = true;

        for (Character i : input) {
            if (count.get(i) != null) {
                int existing = count.get(i).intValue();
                count.put(i, ++existing);
                if (existing > 1) {
                    isUnique = false;
                    break;
                }
            } else {
                count.put(i, 1);
            }
        }

        if (isUnique) {
            System.out.println("chars in string are unique.");
        } else {
            System.out.println("chars in string are not unique");
        }
    }

    private static void findWithoutUsingMaps(char[] input) {
        boolean isUnique = true;
        for (int i=0; i<input.length-1; i++) {
            for (int j=i+1; j<input.length; j++) {
                if (input[i] == input[j]) {
                    isUnique = false;
                    break;
                }
            }
        }

        if (isUnique) {
            System.out.println("chars in string are unique.");
        } else {
            System.out.println("chars in string are not unique");
        }
    }
}
