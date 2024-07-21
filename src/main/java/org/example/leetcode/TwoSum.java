package org.example.leetcode;

import com.alibaba.fastjson.JSON;
import org.example.configuration.ListNode;
import org.springframework.boot.web.client.RootUriTemplateHandler;

import java.math.BigInteger;
import java.sql.Array;
import java.util.*;

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

//数组总和1
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            ans = findCombination(i, ans, candidates,subList,target);
        }
        return ans;

    }

    public static List<List<Integer>> findCombination(int index, List<List<Integer>> ans,int[] candidates,List<Integer> subList,int target) {
        int sum = 0;
        for(int ele : subList){
            sum += ele;
        }
        if (sum == target){
            if (!ans.contains(subList)) {
                ans.add(subList);
            }
            return ans;
        }else if (sum > target){
            return ans;
        }

        List<Integer> temp = new ArrayList<>();
        temp.addAll(subList);
        temp.add(candidates[index]);

        while (index < candidates.length) {
            findCombination(index, ans, candidates, temp, target);
            index++;
        }


        return ans;
    }

    //数组总和2
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination2(0, ans, candidates,new ArrayList<>(),target);
        return ans;

    }

    public static void findCombination2(int index, List<List<Integer>> ans,int[] candidates,List<Integer> subList,int target) {
        int sum = getSum(subList);
        if (sum == target){
            ans.add(new ArrayList<>(subList));
            return;
        }else if (sum > target){
            return;
        }
        if (index >= candidates.length){
            return;
        }

        while (index < candidates.length) {
            subList.add(candidates[index]);
            findCombination2(index+1, ans, candidates, subList, target);
            subList.remove(subList.size() - 1);
            while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
                index += 1;
            }
            index++;
        }
    }

    private static int getSum(List<Integer> subList) {
        int sum = 0;
        for (int ele : subList) {
            sum += ele;
        }
        return sum;
    }

    private static boolean isRepeat(List<List<Integer>> ans, List<Integer> subList ){
        for (List<Integer> ele : ans){
            if (ele.containsAll(subList)){
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> customCombine(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        customRecur(result, new ArrayList<>(), candidates, 0, 0, target);
        return result;
    }

    public static void customRecur(List<List<Integer>> result, List<Integer> candidate, int[] candidates, int pos, Integer currentSum, Integer targetSum) {
        if (currentSum == targetSum) {
            result.add(new ArrayList<>(candidate));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            Integer tempSum = currentSum + candidates[i];
            if (tempSum > targetSum) {
                return;
            }
            candidate.add(candidates[i]);
            customRecur(result, candidate, candidates, i+1, tempSum, targetSum);
            candidate.remove(candidate.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) {
                i += 1;
            }
        }
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        StringBuilder res = new StringBuilder();
        int fac = 0;
        for (int i = chars2.length -1; i >= 0 ; i--) {
            StringBuilder cur = calInteger(chars1, chars2[i],fac++);
            res = sumByString(res, cur);
        }

        return res.toString();
    }

    private static StringBuilder calInteger(char[] chars1,char multy,int factor) {
        StringBuilder builder = new StringBuilder();
        int outNum = 0;
        for (int i = chars1.length -1; i >=0; i--) {
            int tem = (int) (chars1[i] - '0' ) * (int) (multy-'0') + outNum;
            builder.insert(0,tem % 10);
            outNum = tem /10;
        }
        if (outNum != 0){
            builder.insert(0,outNum);
        }
        for (int i = 0; i < factor; i++) {
            builder.append("0");
        }
        return builder;
    }

    private static StringBuilder sumByString(StringBuilder stringBuilder1, StringBuilder stringBuilder2){
        StringBuilder maxString = stringBuilder1.length() > stringBuilder2.length() ?  stringBuilder1 : stringBuilder2;
        StringBuilder minString = stringBuilder1.length() <=  stringBuilder2.length() ? stringBuilder1 : stringBuilder2;

        int maxLen = maxString.length();
        int minLen = minString.length();

        StringBuilder res = new StringBuilder();
        long outNum = 0;
        for (int i = 0; i < maxString.length(); i++){
            if (i < minString.length()) {
                long sum = maxString.charAt(maxLen - 1 - i) - '0' + minString.charAt(minLen - 1 -i) -'0' + outNum;
                res.insert(0,sum % 10);
                outNum = sum / 10;
            }else {
                long sum = maxString.charAt(maxLen - 1 - i) - '0' + outNum;
                res.insert(0,sum % 10);
                outNum = sum /10;
            }
        }
        if (outNum != 0){
            res.insert(0,outNum);
        }
        return res;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode first = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = first;
            first = head;
            head = nextNode;
        }
        return first;
    }


    public static void main(String[] args) {
        String tes = "ab_a";
        String replaceStr = tes.replaceAll("[\\W_]+", "").toLowerCase();
        System.out.println(replaceStr);
        Random seed = new Random(100);
        for (int i = 0; i < 20; i++) {
            System.out.println(seed.nextInt());
        }
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode ans = reverseList(node1);

        //        result.forEach(System.out::println);
    }

}
