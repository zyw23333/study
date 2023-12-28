package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] code = new int[2];
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i]) && result.get(target - nums[i]) != i) {
                code[0] = i;
                code[1] = result.get(target - nums[i]);
                break;
            }
        }
        return code;
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int startzero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startzero = startzero == -1 ? i : startzero;
                continue;
            }
            if (startzero!= -1) {
                swap(nums, startzero, i);
                startzero += 1;
            }
        }
    }
    //在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums,target);
        if (start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        int end = lowerBound(nums,target+1);
        return new int[]{start,end-1};
    }

    public static int lowerBound(int[] nums, int target){
        int start = 0,end = nums.length-1;
        while (start <= end){
            int mid = (start + end)/2;
            if (nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    //【搜索插入的位置】给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public static int searchInsert(int[] nums, int target) {
        int p = 0, q = nums.length-1;
        int mid = -1;
        if (nums.length == 1){
            if (nums[0] == target){
                return 0;
            }
            return nums[0] > target ? 0 : 1;
        }
        while (p < q) {
            mid = (p+q)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                q = mid-1;
            }else {
                p = mid+1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,7,7,7};
        int[] ans = searchRange(nums, 8);
        for (int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }

    }
}
