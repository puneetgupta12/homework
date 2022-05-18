package com.gupta.java.personal.arrays;

/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence?
 */
public class LongestSequence {
    public static void main(String[] args) {
        //Longest consecutive sequence is: zzzzzzzzzzzzzzzz
        String input = "aabbcccddddddeeeeeezzzzzzzzzzzzzzzzzzzzzzzzzzzzxxxxxxxxxxxxxxxxxxx";
        System.out.println(findLongestRunningSequenceNaive(input));
    }

    private static String findLongestRunningSequenceNaive(String input) {
        char[] inputCharArr = input.toCharArray();
        char[] seqArr = new char[inputCharArr.length];
        int max = 0;

        for (int i = 0; i < inputCharArr.length; i++) {
            int count = 0;
            char[] outCharArr = new char[inputCharArr.length];
            for (int j = i; j < inputCharArr.length; j++) {
                if (inputCharArr[i] == inputCharArr[j]) {
                    outCharArr[count] = inputCharArr[i];
                    count++;

                    if (j == inputCharArr.length - 1) {
                        if (count > max) {
                            max = count;
                            seqArr = outCharArr;
                        }
                    }
                } else {
                    if (count > max) {
                        max = count;
                        seqArr = outCharArr;
                    }
                    break;
                }
            }
        }

        return String.valueOf(seqArr);
    }
}
