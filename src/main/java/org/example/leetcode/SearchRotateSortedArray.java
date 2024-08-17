package org.example.leetcode;

/**
 * search target number in a rotated ascending sorted array
 * @Date 2024/8/12
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class SearchRotateSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) / 2 + (left + right) % 2;
            if (nums[left] < nums[right]) {
                if (target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] > nums[right]) {
                    if (target < nums[mid] && target > nums[left]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    if (target < nums[mid] || target > nums[right]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
            }
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
