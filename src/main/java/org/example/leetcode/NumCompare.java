package org.example.leetcode;

/**
 * 自己出的一道题，给定一个数组，要求整理后奇数都在奇数下标，偶数都在偶数下标
 * 奇偶不平衡的排在最后
 * @Date 2024/8/3
 * @Author zhang
 * If any question, please mail zhang_yiwei@trip.com
 **/
public class NumCompare {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2, 6};
        int[] result = new NumCompare().sortArrayByParityII(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int odd = 1;
        int even = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[even] = num;
                even += 2;
            } else {
                result[odd] = num;
                odd += 2;
            }
        }
        return result;
    }
}
