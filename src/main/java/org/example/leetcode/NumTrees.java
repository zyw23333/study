package org.example.leetcode;

/**
 * leetcode hot-100 96
 */
public class NumTrees {
    public static int numsTrees(int n) {
        int[] count = new int[20];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numsTrees(3));
        System.out.println(numsTrees(1));
    }
}
