package org.example.leetcode;

import java.util.*;

/**
 * merge overlapping intervals in intervals array
 * @Date 2024/8/7
 * @Author zhang
 * If any question, please mail zhang_yiwei@trip.com
 **/
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i;
            for (; j < intervals.length; j++) {
                // check overlapping
                if (intervals[j][0] > end) {
                    break;
                }
                end = Math.max(end, intervals[j][1]);
                start = Math.min(start, intervals[j][0]);
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            result.add(temp);
            i = j == i ? i : j - 1;
        }
        return result.stream()
                .map(item -> item.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][] result = merge(intervals);
        for (int[] ints : result) {
            System.out.println(ints[0] + " " + ints[1]);
        }

    }
}
