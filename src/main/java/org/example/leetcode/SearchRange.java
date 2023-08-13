package org.example.leetcode;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = 0, right = nums.length - 1;
        int mid;
        int start = -1, end = -1; //表示结果区间的起始和结束
        while(left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        start = left < nums.length && nums[left] == target ? left : -1;
        left = 0;
        right = nums.length - 1;
        while(left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        end = right >= 0 && nums[right] == target ? right : -1;
        result[0] = start;
        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,7,7,8,8,10};
        int[] result = searchRange(test, 5);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
