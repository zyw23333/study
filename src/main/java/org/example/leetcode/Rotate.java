package org.example.leetcode;

public class Rotate {
    public static void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }
        int mid = matrix.length / 2 - 1;
        int swap, store;
        for (int i = 0; i <= mid; i++) {
            for (int j = 0; j <= mid; j++) {
                int targetLine = i, targetColumn = j;
                swap = matrix[targetLine][targetColumn];
                for (int k = 0; k < 4; k++) {
                    int swapLine, swapColumn;
                    swapLine = targetColumn;
                    swapColumn = matrix.length - 1 - targetLine;
                    store = matrix[swapLine][swapColumn];
                    matrix[swapLine][swapColumn] = swap;
                    swap = store;
                    targetLine = swapLine;
                    targetColumn = swapColumn;
                }
            }
        }
        if (matrix.length % 2 ==1) {
            mid = (matrix.length + matrix.length % 2) / 2 - 1;
            for (int i = 0; i <= mid; i++) {
                int targetLine = i, targetColumn = mid;
                swap = matrix[targetLine][targetColumn];
                for (int k = 0; k < 4; k++) {
                    int swapLine, swapColumn;
                    swapLine = targetColumn;
                    swapColumn = matrix.length - 1 - targetLine;
                    store = matrix[swapLine][swapColumn];
                    matrix[swapLine][swapColumn] = swap;
                    swap = store;
                    targetLine = swapLine;
                    targetColumn = swapColumn;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(test);
        for (int[] i : test) {
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}
