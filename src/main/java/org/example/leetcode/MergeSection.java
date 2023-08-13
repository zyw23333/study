package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSection {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            int j;
            for (j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            i = j - 1;
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3},{4,5},{2,6},{15,18},{8,10}};
        int[][] result = merge(test);
        for (int[] i : result) {
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}
