package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] code = new int[2];
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i]) && result.get(target - nums[i]) != i) {
                code[0] = i;
                code[1] = result.get(target - nums[i]);
                break;
            }
        }
        return code;
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int startzero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startzero = startzero == -1 ? i : startzero;
                continue;
            }
            if (startzero!= -1) {
                swap(nums, startzero, i);
                startzero += 1;
            }
        }
    }

    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
//        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result = new int[]{4,2,4,4,3,0,0,0,5,1,0};
        moveZeroes(result);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
