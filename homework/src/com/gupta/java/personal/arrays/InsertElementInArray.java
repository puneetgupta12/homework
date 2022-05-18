package com.gupta.java.personal.arrays;

import java.util.Arrays;

public class InsertElementInArray {
    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5, 6, 7, 8};

        insertElement(in, 5, 8712564);
    }

    private static void insertElement(int[] in, int atPosition, int elementToInsert) {
        int[] newArr = new int[in.length + 1];

        for (int i=0; i<atPosition; i++) {
            newArr[i] = in[i];
        }

        newArr[atPosition] = elementToInsert;

        for (int j=atPosition+1; j<=in.length; j++) {
            newArr[j] = in[j - 1];
        }

        Arrays.stream(newArr).forEach(System.out::println);
    }
}
