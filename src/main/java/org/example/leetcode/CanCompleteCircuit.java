package org.example.leetcode;

/**
 * leetcode 134
 */
public class CanCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int max = Integer.MIN_VALUE, sum = 0, pos = -1;
        for (int i = 0; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
        }
        for (int i = 0 ; i < gas.length; i++) {
            if (gas[i] > 0) {
                int tempPos = (i + 1) % gas.length;
                sum = gas[i];
                while (gas[tempPos] > 0 && tempPos != i) {
                    sum += gas[tempPos++];
                }
                if (sum > max) {
                    max = sum;
                    pos = i;
                }
                i = tempPos < i ? gas.length : tempPos;
            }
        }
        sum = 0;
        if (pos != -1) {
            for (int i =0 ; i < gas.length; i++) {
                int tempPos = (pos + i) % gas.length;
                sum += gas[tempPos];
                if (sum < 0) {
                    return -1;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{5,8,2,8}, cost = new int[]{6,5,6,6};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
