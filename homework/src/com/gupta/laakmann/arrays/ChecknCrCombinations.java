package com.gupta.laakmann.arrays;

import java.util.ArrayList;
import java.util.List;

public class ChecknCrCombinations {
    /*
        arr -> input array
        data -> temporary array to contain combinations
        start & end -> start and end indexes of the input array
        index -> current index in data array
        r -> number of combinations
     */
    public static void combination(List<String> combinations, char arr[], char data[], int start, int end, int index, int r)
    {
        if(index == r)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < r; j++) {
                //combinations.add(data[j]);
                sb.append(data[j]);
            }
            //combinations.add('\n');
            combinations.add(sb.toString());

            return;
        }

        for(int i = start; i <= end && end - i + 1 >= r - index; i++)
        {
            data[index] = arr[i];
            combination(combinations, arr, data, i+1, end, index+1, r);
        }
    }
    public static void main(String[] args)
    {
        String input = "wxyz";
        //int r = 2;
        //char[] data = new char[r];
        List<String> combinations = new ArrayList<>();

        //Print all range of combinations from 1, 2, 3 ... n
        for (int i=0; i<=input.toCharArray().length; i++) {
            char[] data = new char[i+1];
            combination(combinations, input.toCharArray(), data, 0, input.toCharArray().length - 1, 0, i);
        }
        combinations.forEach(System.out::print);
    }
}
