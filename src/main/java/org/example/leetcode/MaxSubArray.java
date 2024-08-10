package org.example.leetcode;

import java.util.Arrays;

/**
 * leetcode hot-100 54
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int[] total = new int[nums.length];
        Arrays.fill(total, Integer.MIN_VALUE);
        total[0] = nums[0];
        for (int i = 1 ;i < nums.length; i++) {
            total[i] = Math.max(total[i - 1] + nums[i], nums[i]);
        }
        return Arrays.stream(total).max().getAsInt();
    }

    public static void main(String[] args) {
    }
}
