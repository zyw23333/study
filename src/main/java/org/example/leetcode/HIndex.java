package org.example.leetcode;

/**
 * leetcode 274
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        int result = 0;
        int[] flag = new int[1001];
        for (int i = 0 ; i < citations.length; i++) {
            flag[citations[i]]++;
        }
        int sum = 0;
        for (int i = flag.length - 1; i >=0; i--) {
            sum += flag[i];
            flag[i] = sum;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] >= i) {
                result = i;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,1};
        System.out.println(hIndex(input));
    }
}
