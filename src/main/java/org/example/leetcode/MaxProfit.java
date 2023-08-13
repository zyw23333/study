package org.example.leetcode;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPos = 0, maxPos = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minPos]) {
                minPos = i;
            } else if (prices[i] > prices[maxPos] && i > minPos) {
                maxPos = i;
            }
            profit = maxPos < minPos ? Math.max(profit, prices[i] - prices[minPos])
                    : Math.max(profit, prices[maxPos] - prices[minPos]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,3,2,1};
        System.out.println(maxProfit(test));
    }
}
