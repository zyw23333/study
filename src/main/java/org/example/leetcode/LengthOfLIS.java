package org.example.leetcode;

/**
 * calculate the max length of strictly increasing subsequence in an array
 * @Date 2024/8/16
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxValue = -1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
}
