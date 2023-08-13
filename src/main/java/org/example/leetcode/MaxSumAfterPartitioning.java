package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode 1043
 */
public class MaxSumAfterPartitioning {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        PriorityQueue<Store> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.val));
        int ans = 0;
        Set<Integer> count = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(new Store(arr[i], i));
                count.add(arr[i]);
            }
            else {
                if (!count.contains(arr[i])) {
                    Store least = queue.poll();
                    count.remove(least.val);
                    queue.offer(least.val > arr[i] ? least : new Store(arr[i], i));
                    count.add(Math.max(least.val, arr[i]));
                }
            }
        }
        List<Store> tempList = queue.stream().sorted(Comparator.comparingInt(o -> o.pos)).collect(Collectors.toList());
        int end = Math.min(tempList.size(), k);
        if (end <= 1) {
            return ans += tempList.get(0).val * arr.length;
        }
        for (int i = 0; i < end; i++) {
            if (i == 0) {
                ans += tempList.get(i).val * (tempList.get(i).pos + 1);
                continue;
            }
            ans += tempList.get(i - 1).val > tempList.get(i).val ? tempList.get(i-1).val * (tempList.get(i).pos - tempList.get(i-1).pos - 1) + tempList.get(i).val
                    : tempList.get(i).val * (tempList.get(i).pos - tempList.get(i-1).pos);
            if (i == end - 1) {
                ans += tempList.get(i).val * (arr.length - tempList.get(i).pos - 1);
            }
        }
        return ans;
    }

    static class Store {
        int val;
        int pos;

        Store(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(maxSumAfterPartitioning(test, 4));
    }
}
