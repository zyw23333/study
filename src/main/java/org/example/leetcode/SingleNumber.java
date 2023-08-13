package org.example.leetcode;

/**
 * leetcode hot-100 136
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
