package org.example.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Date 2024/8/16
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int before = triangle.get(0).get(0);
        dp[0] = before;
        for (int i = 1; i < triangle.size(); i++) {
            before = dp[0];
            dp[0] = dp[0] + triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                int temp = dp[j];
                dp[j] = (j == i ? before : Math.min(before, dp[j])) + triangle.get(i).get(j);
                before = temp;
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(-2, -3)
        );
        System.out.println(minimumTotal(triangle));
    }
}
