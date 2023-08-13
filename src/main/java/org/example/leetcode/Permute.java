package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode hot-100 46
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] flag = new int[nums.length];
        Arrays.fill(flag, -1);
        recur(new ArrayList<>(), result, flag, nums);
        return result;
    }

    public static void recur(List<Integer> temp, List<List<Integer>> ans, int[] flag, int[] candidate) {
        if (temp.size() == candidate.length) {
            List<Integer> result = new ArrayList<>(temp);
            ans.add(result);
            return;
        }
        for (int i = 0; i < candidate.length; i++) {
            if (flag[i] == -1) {
                flag[i] = 1;
                temp.add(candidate[i]);
                recur(temp, ans, flag, candidate);
                flag[i] = -1;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        List<List<Integer>> result = permute(test);
        result.forEach(System.out::println);
    }
}
