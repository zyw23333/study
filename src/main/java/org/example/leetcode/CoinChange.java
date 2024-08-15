package org.example.leetcode;

import java.util.Arrays;

/**
 * Give an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * @Date 2024/8/15
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] nums = new int[amount + 1];
        Arrays.fill(nums, amount + 1);
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    nums[i] = Math.min(nums[i], nums[i - coin] + 1);
                }
            }
        }
        return nums[amount] != amount + 1 ? nums[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins, 3));
    }
}
