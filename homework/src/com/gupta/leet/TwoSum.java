package com.gupta.leet;

import java.util.Arrays;
import java.util.Scanner;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.


    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] in = new int[] {2,7,11,15};
        int target = 9;

        //O(n2) solution
        Arrays.stream(twoSum(in, target)).forEach(System.out::println);

        //Non O(n2) solution
        //Arrays.stream(fasterTwoSum(in, target, 0, 1)).forEach(System.out::println);
    }

    private static int[] twoSum(int[] input, int target) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }

    private static int[] fasterTwoSum(int[] in, int target, int start, int end) {
        if (end == in.length) return new int[] {};
        if (in[start] + in[end] == target) {
            return new int[] {start,end};
        }
        fasterTwoSum(in, target, start, end + 1);
        fasterTwoSum(in, target, start + 1, end + 1);
        return in;
    }
}
