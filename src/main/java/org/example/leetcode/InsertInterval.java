package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leetcode 57 插入区间
 */
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(1);
        List<Integer> test1 = new ArrayList<>();
        test1.add(2);
        test1.add(2);
        result.add(test);
        result.add(test1);
        int[][] ii = result.stream()
                .map(item -> item.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        for (int i = 0; i < ii.length; i++) {
            for (int j = 0; j < ii[i].length; j++) {
                System.out.println(ii[i][j]);
            }
        }
        return new int[0][];
    }

    public <T> void func(T item) {
        int[] value = (int[]) item;
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
    }

    public static void main(String[] args) {
//        insert(new int[0][], new int[0]);
        InsertInterval test = new InsertInterval();
        int[] input = new int[]{1,3,2,4};
        test.func(input);
    }
}
