package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * give a target num and array,
 * find the min length of sub Array which sum is greater than or equal to target
 * @Date 2024/8/6
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, sum = 0, result = Integer.MAX_VALUE;
        while(left < nums.length) {
            if (sum < target) {
                if (right < nums.length) {
                    sum += nums[right++];
                    continue;
                }
                break;
            }
            while (sum >= target) {
                result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(213, nums));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.computeIfAbsent(2, k -> 1);
        System.out.println(map.size());
    }
}
