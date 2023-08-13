package org.example.leetcode;

import java.util.PriorityQueue;

/**
 * leetcode hot-100 215
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> topK = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < k) {
                count += 1;
                topK.add(nums[i]);
            } else {
                if (nums[i] > topK.peek()) {
                    topK.poll();
                    topK.add(nums[i]);
                }
            }
        }
        return topK.peek();
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(test, 4));
    }
}
