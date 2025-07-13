package com.gupta.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    Example 2:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.


    Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104
 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = new int[] {2,4,1};
        long startTime = System.nanoTime();
        System.out.println("Output: " + maxProfit(prices));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationMs = duration / 1_000_000.0;
        System.out.println("Time taken: " + durationMs + " ms");
    }

    public static int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > 0 && diff > max) {
                    max = diff;
                }
            }
        }

        return max;
    }
}
