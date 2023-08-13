package org.example.leetcode;

/**
 * leetcode hot-100 221
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] dp = new int[columns];
        int before;
        for (int i = 0; i < rows; i++) {
            before = 301;
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        before = dp[j];
                        dp[j] = 1;
                    } else {
                        int temp = dp[j];
                        dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), before) + 1;
                        before = temp;
                    }
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'0','1'},{'0','1'},{'1','1'}};
        System.out.println(maximalSquare(test));
    }
}
