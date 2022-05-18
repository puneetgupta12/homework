package com.gupta.java.personal.arrays;

//With Time Complexity
public class FindDuplicateString {
    public static void main(String[] args) {
        String[] strArr1 = {"Hello", "World", "is", "Rain"};
        String[] strArr2 = {"Wolf", "World", "is"};

        findDuplicates(strArr1, strArr2);
    }

    private static void findDuplicates(String[] arr1, String[] arr2) {
        boolean found = false;

        for (int i=0; i<Math.min(arr1.length, arr2.length); i++) {
            if (arr1[i].equals(arr2[i])) {
                System.out.println("Duplicate word: " + arr1[i]);
                found = true;
            }
        }

        if (!found)
            System.out.println("No duplicates");
    }
}
