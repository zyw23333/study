package org.example.leetcode;

/**
 * @Date 2024/8/16
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0,0,0,0},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
