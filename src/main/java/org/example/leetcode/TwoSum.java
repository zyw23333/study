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

    public static void main(String[] args) {
//        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result = twoSum(new int[]{3,2,4}, 6);
        for(int i : result) {
            System.out.println(i);
        }
    }
}
