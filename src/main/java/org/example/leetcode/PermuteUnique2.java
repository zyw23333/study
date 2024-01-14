package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47 全排列2
 */
public class PermuteUnique2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flags = new boolean[nums.length];
        recursive(result, new ArrayList<>(), 0, nums, flags);
        return result;
    }

    public static void recursive(List<List<Integer>> answer, List<Integer> subAnswer, int count, int[] nums, boolean[] flags) {
        if (count == nums.length) {
            answer.add(new ArrayList<>(subAnswer));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                flags[i] = true;
                subAnswer.add(nums[i]);
                recursive(answer, subAnswer, count + 1, nums, flags);
                subAnswer.remove(subAnswer.size() - 1);
                flags[i] = false;
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    //skip same element
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
    }
}
