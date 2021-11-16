package com.gupta.laakmann.arrays;

import java.util.HashMap;
import java.util.Map;

/*
    String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
    For example, the string aabcccccaaa would become a2blc5a3.
    If the "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    public static void main(String[] args) {
        //String input = "aabcccccaaa";
        //output = a2blc5a3
        //String input = "abcd";
        String input = "aaaaaabbbbbbbrrrrrrrkkkkkkkkkkkkkkkkzzl"; //output=a6b7r7k16z2l1
        compress(input);
    }

    private static void compress(String input) {
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean allSingles = true;

        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                } else {
                    break;
                }
            }
            count += 1; //Count + 1 for the arr[i] value
            //System.out.println("Letter " + arr[i] + " appears " + count + " times");
            sb.append(arr[i] + String.valueOf(count));
            if (count > 1) allSingles = false;
            i += count - 1; //The actual increment on the outer loop is only (count - 1)
        }

        if (allSingles) {
            System.out.println(input);
        } else {
            System.out.println(sb.toString());
        }
    }
}
