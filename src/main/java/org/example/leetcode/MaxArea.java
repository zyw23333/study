package org.example.leetcode;

public class MaxArea {
    public static int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = -1;
        int left = 0, right = height.length - 1;
        while(left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        int temp = result;
        left = 0;
        right = height.length -1;
        result = -1;
        while(left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[right] > height[left]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return Math.max(temp, result);
    }

    public static void main(String[] args) {
//        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        int[] input = new int[]{1,1};
        System.out.println(maxArea(input));
    }
}
