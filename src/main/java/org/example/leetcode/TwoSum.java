package org.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
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


    //【有效的数独】请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowHashMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> columHashMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> subHashMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                //检查行
                if (rowHashMap.containsKey(i)){
                    if (rowHashMap.get(i).contains(board[i][j])){
                        return false;
                    }else {
                        rowHashMap.get(i).add(board[i][j]);
                    }
                }else {
                    rowHashMap.put(i,new HashSet<>());
                    rowHashMap.get(i).add(board[i][j]);
                }
                //检查列
                if (columHashMap.containsKey(j)){
                    if (columHashMap.get(j).contains(board[i][j])){
                        return false;
                    }else {
                        columHashMap.get(j).add(board[i][j]);
                    }
                }else {
                    columHashMap.put(j,new HashSet<>());
                    columHashMap.get(j).add(board[i][j]);
                }
                //检查小方块
                Integer pos = i / 3 * 3 + j / 3;
                if (subHashMap.containsKey(pos)){
                    if (subHashMap.get(pos).contains(board[i][j])){
                        return false;
                    }else {
                        subHashMap.get(pos).add(board[i][j]);
                    }
                }else {
                    subHashMap.put(pos,new HashSet<>());
                    subHashMap.get(pos).add(board[i][j]);
                }
            }
        }
        return true;
    }


    //外观数列
    public static String countAndSay(int n) {
        String s = "1";
        if (n == 1){
            return  s;
        }
        int i = 2;
        while (i <= n){
            StringBuffer stringBuffer = new StringBuffer();

            char[] chars = s.toCharArray();
            char c = chars[0];
            int number = 0;
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j]){
                    number++;
                }else{
                    stringBuffer.append(number);
                    stringBuffer.append(chars[j-1]);
                    number = 1;
                    c = chars[j];
                }
                if (j == chars.length - 1){
                    stringBuffer.append(number);
                    stringBuffer.append(chars[j]);
                }
            }
            s = stringBuffer.toString();
            i++;
        }
        return s;

    }



    public static void main(String[] args) {
        char[][] test = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        String ans = countAndSay(6);
        System.out.println(ans);

    }


}
