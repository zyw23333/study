package org.example.leetcode;

import java.util.PriorityQueue;

/**
 * leetcode hot-100 152
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] test = new int[]{2, 3, -2, 4};
//        System.out.println(maxProduct(test));
        PriorityQueue<Integer> test = new PriorityQueue<>(Integer::compareTo);
        test.offer(1);
        test.offer(3);
        test.offer(2);
        System.out.println(test);
    }
}
