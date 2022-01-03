package com.gupta.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
    Split a string array into small chunk arrays in java?

    Example:

    [1,2,3,4,5]
    if the chunk size is 1, [1,2,3,4,5]
    if the chunk size is 2, [1,2] and [3,4] and [5]
    if the chunk size is 3, [1,2,3] and [4,5]
    if the chunk size is 4, [1,2,3,4] and [5]
 */
public class SplitArrayIntoChunks {
    public static void main(String[] args) {
        int[] in = {1,2,3,4,5};
        //chunks(in, 2);
        int[][] chunked = chunksNew(in, 2);
        Arrays.stream(chunked)
                .map(Arrays::toString)
                    .forEach(System.out::println);
    }

    private static void chunks(int[] in, int chunkSize) {
        List<int[]> outList = new ArrayList<>();

        int i = 0;

        while (i < in.length) {
            int[] out = Arrays.copyOfRange(in, i, Math.min(i + chunkSize, in.length));
            outList.add(out);
            out = new int[chunkSize + 1];
            i += chunkSize;
        }

        for (int[] ol: outList) {
            System.out.print("[");
            Arrays.stream(ol).forEach(System.out::print);
            System.out.println("]");
        }
    }

    //Pure Java 8
    private static int[][] chunksNew(int[] in, int chunkSize) {
        return IntStream.iterate(0, i -> i + chunkSize)
                .limit((long) Math.ceil((double) in.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(in, j, Math.min(j + chunkSize, in.length)))
                .toArray(int[][]::new);
    }
}
