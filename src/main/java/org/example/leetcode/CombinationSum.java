package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode hot-100 39
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int begin, int num) {
        if (num == 0) {
            List<Integer> result = new ArrayList<>(temp);
            ans.add(result);
        } else if (num < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(ans, temp, candidates, i, num - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11,7};
        List<List<Integer>> result = combinationSum(nums, 100);
        result.forEach(System.out::println);
    }
}
