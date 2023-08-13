package org.example.leetcode;

/**
 * leetcode hot-100 55
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        int max = nums[0];
        int start = 0;
        while(start <= max && start < nums.length) {
            if (max >= nums.length - 1) {
                return true;
            }
            if (start == max && nums[start] == 0) {
                return false;
            }
            max = Math.max(max, start + nums[start]);
            start += 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,0,4};
        System.out.println(canJump(test));
    }
}
