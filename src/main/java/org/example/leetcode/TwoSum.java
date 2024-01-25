package org.example.leetcode;

import com.alibaba.fastjson.JSON;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
            if (startzero != -1) {
                swap(nums, startzero, i);
                startzero += 1;
            }
        }
    }

    //在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }
        int end = lowerBound(nums, target + 1);
        return new int[] {start, end - 1};
    }

    public static int lowerBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
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
        int p = 0, q = nums.length - 1;
        int mid = -1;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return nums[0] > target ? 0 : 1;
        }
        while (p < q) {
            mid = (p + q) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                q = mid - 1;
            } else {
                p = mid + 1;
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
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                //检查行
                if (rowHashMap.containsKey(i)) {
                    if (rowHashMap.get(i).contains(board[i][j])) {
                        return false;
                    } else {
                        rowHashMap.get(i).add(board[i][j]);
                    }
                } else {
                    rowHashMap.put(i, new HashSet<>());
                    rowHashMap.get(i).add(board[i][j]);
                }
                //检查列
                if (columHashMap.containsKey(j)) {
                    if (columHashMap.get(j).contains(board[i][j])) {
                        return false;
                    } else {
                        columHashMap.get(j).add(board[i][j]);
                    }
                } else {
                    columHashMap.put(j, new HashSet<>());
                    columHashMap.get(j).add(board[i][j]);
                }
                //检查小方块
                Integer pos = i / 3 * 3 + j / 3;
                if (subHashMap.containsKey(pos)) {
                    if (subHashMap.get(pos).contains(board[i][j])) {
                        return false;
                    } else {
                        subHashMap.get(pos).add(board[i][j]);
                    }
                } else {
                    subHashMap.put(pos, new HashSet<>());
                    subHashMap.get(pos).add(board[i][j]);
                }
            }
        }
        return true;
    }

    //外观数列
    public static String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }
        int i = 2;
        while (i <= n) {
            StringBuffer stringBuffer = new StringBuffer();

            char[] chars = s.toCharArray();
            char c = chars[0];
            int number = 0;
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j]) {
                    number++;
                } else {
                    stringBuffer.append(number);
                    stringBuffer.append(chars[j - 1]);
                    number = 1;
                    c = chars[j];
                }
                if (j == chars.length - 1) {
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
            ans = findCombination(i, ans, candidates, subList, target);
        }
        return ans;

    }

    public static List<List<Integer>> findCombination(int index, List<List<Integer>> ans, int[] candidates, List<Integer> subList,
                                                      int target) {
        int sum = 0;
        for (int ele : subList) {
            sum += ele;
        }
        if (sum == target) {
            if (!ans.contains(subList)) {
                ans.add(subList);
            }
            return ans;
        } else if (sum > target) {
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
        findCombination2(0, ans, candidates, new ArrayList<>(), target);
        return ans;

    }

    public static void findCombination2(int index, List<List<Integer>> ans, int[] candidates, List<Integer> subList, int target) {
        int sum = getSum(subList);
        if (sum == target) {
            ans.add(new ArrayList<>(subList));
            return;
        } else if (sum > target) {
            return;
        }
        if (index >= candidates.length) {
            return;
        }

        while (index < candidates.length) {
            subList.add(candidates[index]);
            findCombination2(index + 1, ans, candidates, subList, target);
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

    private static boolean isRepeat(List<List<Integer>> ans, List<Integer> subList) {
        for (List<Integer> ele : ans) {
            if (ele.containsAll(subList)) {
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

    public static void customRecur(List<List<Integer>> result, List<Integer> candidate, int[] candidates, int pos, Integer currentSum,
                                   Integer targetSum) {
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
            customRecur(result, candidate, candidates, i + 1, tempSum, targetSum);
            candidate.remove(candidate.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i += 1;
            }
        }
    }

    //LCP 18. 早餐组合
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int p = 0, q = drinks.length - 1;
        long res = 0;
        while (p < staple.length && q >= 0) {
            if (staple[p] + drinks[q] <= x) {
                res += q + 1;
                p++;
            } else {
                q--;
            }
        }
        return (int) (res % 1000000007);
    }

    //String[] words = new String[]{"cd","ac","dc","ca","zz"};
    //String[] wordsReverse = new String[]{"dc","ca",cd","ac","zz"};
    // 有两对匹配的数据
    public static int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> stringHashSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (stringHashSet.contains(words[i])) {
                continue;
            }
            String sbRever = new StringBuilder(words[i]).reverse().toString();
            stringHashSet.add(sbRever);
        }
        return words.length - stringHashSet.size();
    }

    //二进制求和
    public static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int maxLength = Math.max(charsA.length, charsB.length);
        int outNum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int lengthA = charsA.length;
        int lengthB = charsB.length;

        for (int i = 0; i < maxLength; i++) {
            if (i >= lengthA) {
                int sum = (charsB[lengthB - i - 1] + outNum - '0') % 2;
                stringBuilder.insert(0, sum);
                outNum = (charsB[lengthB - i - 2] - '0' + outNum) / 2;
            } else {
                if (i >= charsB.length) {
                    int sum = (charsA[lengthA - i - 1] + outNum - '0') % 2;
                    stringBuilder.insert(0, sum);
                    outNum = (charsA[lengthA - i - 1] - '0' + outNum) / 2;
                } else {
                    int sum = (charsA[lengthA - i - 1] - '0' + charsB[lengthB - i - 1] - '0' + outNum) % 2;
                    stringBuilder.insert(0, sum);
                    outNum = (charsA[lengthA - i - 1] - '0' + charsB[lengthB - i - 1] - '0' + outNum) / 2;
                }
            }
        }
        if (outNum != 0) {
            stringBuilder.insert(0, outNum % 2);
        }

        return stringBuilder.toString();
    }

    //假设小招会一种魔法，他可以把一个字符串s插入到另外一个字符串t的任意位置。
    //小招刚开始有一个空串，每次可以把“cm"按照他的魔法进行若干次操作(包括0次)，从而得到一个新的结果字符串。
    //那么对于一个结果字符串，如果小招可以上面的操作变成的话，那么输出true，否则输出false
    public static boolean magicString(String s) {
        // write code here
        if (s.length() % 2 == 1) {
            return false;
        }
        String temp = s;
        while (true) {
            String next = temp.replace("cm", "");
            if (next.length() == 0) {
                return true;
            }
            if (temp.length() == next.length()) {
                return false;
            }
            temp = next;
        }
    }

    //leetCode100: 相同的树
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val){
            return false;
        }
        boolean sameTreeLeft = isSameTree(p.left, q.left);
        if (!sameTreeLeft){
            return false;
        }
        boolean sameTreeRight = isSameTree(p.right, q.right);
        if (!sameTreeRight){
            return false;
        }
        return true;
    }

    //public static boolean isSame()





    public static void main(String[] args) {
        int[] staple = new int[]{2,1,1};
        int[] drinks = new int[]{8,9,5,1};

        String a = "1010";
        String b = "1011";
        String input = "ccmm";

        //String s = addBinary(a, b);
        boolean b1 = magicString(input);
        System.out.println(b1);

        //result.forEach(System.out::println);


    }

}
