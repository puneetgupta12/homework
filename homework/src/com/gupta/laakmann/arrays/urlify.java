package com.gupta.laakmann.arrays;

import java.util.Arrays;

//Replace all spaces with '%20'
public class urlify {
    public static void main(String[] args) {
        String input = "Mr John Smith";
        replaceSpaces(input);
    }

    private static void replaceSpaces(String input) {
        int countOfSpaces = 0;
        char[] inputCharArray = input.toCharArray();

        for (int i=0; i<inputCharArray.length; i++) {
            if (inputCharArray[i] == ' ') {
                countOfSpaces++;
            }
        }

        int j = 0;
        char[] outputArray = new char[inputCharArray.length + countOfSpaces * 2]; //3 - 1 because space is going to be replaced by %

        for (int i=0; i<inputCharArray.length; i++) {
            if (inputCharArray[i] == ' ') {
                outputArray[j] = '%';
                outputArray[j+1] = '2';
                outputArray[j+2] = '0';
                j = j+3;
            } else {
                outputArray[j] = inputCharArray[i];
                j++;
            }
        }

        System.out.println(outputArray);
    }
}
