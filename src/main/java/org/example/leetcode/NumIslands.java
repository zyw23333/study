package org.example.leetcode;

/**
 * leetcode hot-100 200
 */
public class NumIslands {
    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '#') {
                    continue;
                }
                if (grid[i][j] == '1') {
                    result += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int line, int column) {
        if (line < 0 || line >= grid.length || column < 0 || column >= grid[line].length
                || grid[line][column] == '#' || grid[line][column] == '0') {
            return;
        }
        grid[line][column] = '#';
        int[][] rotate = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < rotate.length; i++) {
            dfs(grid, line + rotate[i][0], column + rotate[i][1]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
        char[][] grid1 = new char[][]{{'0'},{'1'}};
        System.out.println(numIslands(grid1));
    }
}
