package org.example.leetcode;

/**
 * leetcode 238
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sum = nums[0];
        result[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = sum * nums[i];
            sum *= nums[i];
        }
        result[nums.length - 1] = sum;
        sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i >= 1) {
                result[i] = result[i - 1] * sum;
                sum *= nums[i];
            }
        }
        result[0] = sum;
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1,1,0,-3,3};
        int[] result = productExceptSelf(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
