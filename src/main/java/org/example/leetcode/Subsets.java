package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode hot-100 78
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        dfs(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> temp, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> copy = new ArrayList<>(temp);
            ans.add(copy);
            return;
        }
        temp.add(nums[start]);
        dfs(ans, temp, start+1, nums);
        temp.remove(temp.size() - 1);
        dfs(ans, temp, start+1, nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(subsets(nums));
    }
}
