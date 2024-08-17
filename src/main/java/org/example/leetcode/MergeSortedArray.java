package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * merge two sored array into one sorted array
 * @Date 2024/8/3
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[i + j + 1] = nums2[j];
                j--;
            } else {
                nums1[i + j + 1] = nums1[i];
                i--;
            }
        }
        i = 0;
        if (j >= 0) {
            while (j >= 0) {
                nums1[i + j] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
//        int[] nums2 = new int[]{1, 2, 3};
//        merge(nums1, 0, nums2, 1);
//        for (int j : nums1) {
//            System.out.println(j);
//        }
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] == target) {
                System.out.println(start + " " + end);
            }
            start++;
        }
    }
}
