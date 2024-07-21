package org.example.leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * leetcode 180 文件组合
 */
public class FileCombination {
    public static int[][] fileCombination(int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 1, right = 1, currentSum = 0;
        while(left + left - 1 <= target) {
            if (currentSum == target) {
                List<Integer> tempResult = new ArrayList<>();
                for (int i = left; i < right; i++) {
                    tempResult.add(i);
                }
                result.add(tempResult);
                currentSum -= left;
                left += 1;
            } else if (currentSum > target) {
                currentSum -= left;
                left += 1;
            } else {
                currentSum += right;
                right += 1;
            }
        }
        return result.stream()
                .map(item -> item.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int count = 0;
        int[] sum = new int[x + 1];
        for (int i : staple) {
            if (i < x) {
                sum[i]++;
            }
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i-1];
        }
        for (int i : drinks) {
            if (x - i <= 0)
                continue;
            else
                count = (count + sum[x - i]) % 1000000007;
        }
        return count % 1000000007;
    }

    public static void main(String[] args) throws FileNotFoundException {

    }
}
