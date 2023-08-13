package org.example.leetcode;

import java.util.*;

/**
 * leetcode hot-100 15
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
        }
        Map<Integer, Integer> copy = new HashMap<>(count);
        for (int i : count.keySet()) {
            for (int j : count.keySet()) {
                if (i == j && copy.get(i) <= 1) {
                    continue;
                }
                if (copy.containsKey(-i-j) && copy.get(-i-j) > 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(-i-j);
                    result.add(temp);
                    copy.put(i, copy.get(i) - 1);
                    copy.put(j, copy.get(j) - 1);
                    copy.put(-i-j, copy.get(-i-j) - 1);
                }
            }
        }
        return result;
    }

    public void other(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> content = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!content.containsKey(nums[i])) {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                content.put(nums[i], index);
            } else {
                content.get(nums[i]).add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int reverse = -i - j;
                if (content.containsKey(reverse)) {
                    for (int index : content.get(reverse)) {
                        if (index > i && index > j) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(i);
                            temp.add(j);
                            temp.add(index);
                            result.add(temp);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(test));
    }
}
