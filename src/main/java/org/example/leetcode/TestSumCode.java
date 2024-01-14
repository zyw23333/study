package org.example.leetcode;

import org.apache.ibatis.reflection.ArrayUtil;
import org.example.configuration.ListNode;
import org.springframework.util.StringUtils;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TestSumCode {

    public static Integer foo(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        set.add(chars[0]);
        int p = 0, q = 1, maxLen = 1;
        while (q < s.length()) {
            if (!set.contains(chars[q])) {
                set.add(chars[q++]);
                maxLen = Math.max(maxLen, q - p);
                continue;
            }
            while (set.contains(chars[q])) {
                set.remove(chars[p++]);
            }
        }
        return maxLen;
    }

    public static ListNode foo(ListNode t1, ListNode t2) {
        ListNode pre = new ListNode();
        ListNode temp = pre;
        pre.next = t1;
        int increase = 0;
        while (t1 != null || t2 != null) {
            ListNode node1 = t1 == null ? new ListNode(0) : t1;
            ListNode node2 = t2 == null ? new ListNode(0) : t2;
            temp.next = new ListNode((node1.val + node2.val + increase) % 10);
            increase = (node1.val + node2.val + increase) / 10;

            t1 = node1.next;
            t2 = node2.next;
            temp = temp.next;
        }
        if (increase != 0) {
            temp.next = new ListNode(increase);
        }
        return pre.next;
    }

    public static String intToRoman(int num) {
        String[] arr = {"I", "V", "X", "L", "C", "D", "M"};
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);

        StringBuilder ans = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            int count = num / hashMap.get(arr[i]);
            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    ans.append(arr[i]);
                }
                num = num - count * hashMap.get(arr[i]);
            }
            if (num == 0) break;
            if (i >= 2 && i % 2 == 0) {
                int left = num % hashMap.get(arr[i]) / (hashMap.get(arr[i]) / 10);
                if (left == 9) {
                    ans.append(arr[i - 2]);
                    ans.append(arr[i]);
                    num = num - left * (hashMap.get(arr[i]) / 10);
                } else if (left == 4) {
                    ans.append(arr[i - 2]);
                    ans.append(arr[i - 1]);
                    num = num - left * (hashMap.get(arr[i]) / 10);
                }
                if (num == 0) break;
            }
        }
        return ans.toString();

    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);


        int p = 0, q = 1;
        int ans = 0;
        while (p <= s.length() - 1) {
            if (p == s.length() - 1) {
                ans += map.get(String.valueOf(s.charAt(p++)));
                continue;
            }
            int before = map.get(String.valueOf(s.charAt(p)));
            int afer = map.get(String.valueOf(s.charAt(q)));
            if (before < afer) {
                ans += map.get(s.substring(p, q + 1));
                p = q + 1;
                q = p + 1;
                continue;
            }
            ans += map.get(String.valueOf(s.charAt(p)));
            p++;
            q++;
        }
        return ans;

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) return "";
        String s = strs[0];
        int count = 0;
        boolean terminal = false;
        while (true) {
            if (terminal) break;
            for (String str : strs) {
                if (str.length() <= count || str.charAt(count) != strs[0].charAt(count)) {
                    terminal = true;
                    break;
                }
            }
            if (!terminal) count++;
        }
        return s.substring(0, count);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                if (nums[i] + nums[p] > 0) return ans;
                int temp = nums[i] + nums[p] + nums[q];
                if (temp == 0) {
                    ArrayList<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[p]);
                    subAns.add(nums[q]);

                    ans.add(subAns);

                    while (p + 1 < nums.length && nums[p] == nums[p + 1]) {
                        p++;
                    }
                    p++;
                    q--;
                } else if (temp > 0) {
                    q--;
                } else {
                    p++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int offSet = Integer.MAX_VALUE;
        for (int a = 0; a < nums.length; a++) {
            int p = a + 1, q = nums.length - 1;
            while (p < q) {
                int temp = Math.abs(nums[a] + nums[p] + nums[q] - target);
                if (temp < offSet) {
                    ans = nums[a] + nums[p] + nums[q];
                    offSet = temp;
                }
                if (nums[a] + nums[p] + nums[q] - target >= 0) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return ans;
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return getCombinationAns(ans, map, digits, 0, new StringBuffer());

    }

    public static List<String> getCombinationAns(ArrayList<String> combinationList, HashMap<Character, String> map, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            combinationList.add(stringBuffer.toString());
        } else {
            String subNumber = map.get(digits.charAt(index));
            for (int i = 0; i < subNumber.length(); i++) {
                stringBuffer.append(subNumber.charAt(i));
                getCombinationAns(combinationList, map, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
        return combinationList;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode preNode = new ListNode();
        ListNode tempNode = new ListNode();
        ListNode ansNode = tempNode;
        preNode.next = head;
        int len = 0;
        while (preNode.next != null) {
            ListNode cur = new ListNode(preNode.next.val);
            tempNode.next = cur;
            map.put(len, cur);

            len++;
            preNode = preNode.next;
            tempNode = tempNode.next;
        }
        int jump = len - n;
        if (jump == 0) {
            ansNode.next = ansNode.next.next;
        } else {
            ListNode beforNode = map.get(jump - 1);
            beforNode.next = beforNode.next.next;
        }
        return ansNode.next;
    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('f');
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                stack.push(map.get(chars[i]));
            } else {
                if (!stack.pop().equals(chars[i])) return false;
            }

        }
        if (stack.size() == 1 && stack.pop().equals('f')) return true;
        else if (stack.size() > 1) return false;
        else return true;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode pre = new ListNode(0);
        ListNode temp = new ListNode(0);
        pre = temp;
        ListNode p = list1;
        ListNode q = list2;
        while (p != null || q != null) {
            if (p == null) {
                temp.next = q;
                break;
            }
            if (q == null) {
                temp.next = p;
                break;
            }
            if (p.val < q.val) {
                temp.next = p;
                p = p.next;
                temp = temp.next;
            } else {
                temp.next = q;
                q = q.next;
                temp = temp.next;
            }
        }
        return pre.next;
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String[] s = new String[]{"(", ")"};
        Stack<String> stack = new Stack<>();
        int index = 0;
        StringBuffer stringBuffer = new StringBuffer();
        return getCombination(stringBuffer, index, s, stack, n, list);
    }

    public static ArrayList<String> getCombination(StringBuffer subCombination, int leftNum, String[] parentheses, Stack<String> stack, int n, ArrayList<String> ans) {
        if (subCombination.length() == 2 * n) {
            if (stack.size() == 0) {
                ans.add(subCombination.toString());
            }
            return ans;
        }
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == "(") {
                if (leftNum >= n) {
                    continue;
                }
                stack.push(")");
                StringBuffer tempStringBuffer = new StringBuffer(subCombination);
                tempStringBuffer.append(parentheses[i]);
                Stack<String> tempStack = new Stack<>();
                tempStack.addAll(stack);
                getCombination(tempStringBuffer, leftNum + 1, parentheses, tempStack, n, ans);
                stack.pop();
            } else {
                if (stack.size() == 0) {
                    return ans;
                }
                stack.pop();
                StringBuffer tempStringBuffer = new StringBuffer(subCombination);
                tempStringBuffer.append(parentheses[i]);
                Stack<String> tempStack = new Stack<>();
                tempStack.addAll(stack);
                getCombination(tempStringBuffer, leftNum, parentheses, tempStack, n, ans);
            }
        }
        return ans;
    }

    public static ListNode exchangeListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode p = head;
        ListNode q = head.next;

        int temp = p.val;
        p.val = q.val;
        q.val = temp;
        while (q.next != null && q.next.next != null) {
            p = q.next;
            q = q.next.next;
            cur = p;

            temp = p.val;
            p.val = q.val;
            q.val = temp;
        }
        return cur.next;
    }

    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            ans.add(nums[i]);
            len++;
        }
        nums = ans.stream().mapToInt(Integer::valueOf).toArray();
        return ans.size();
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;

        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[p++] = nums[i];
        }
        return p;
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int p = i, q = i + 1;
            while (q < nums.length) {
                if (nums[p] == 0) {
                    while (q < nums.length - 1 && nums[q] == 0) {
                        q++;
                    }
                    exchangeNums(nums, p, q);
                    p++;
                    q++;
                    continue;
                }
                p++;
                q++;
            }
        }

    }

    public static void exchangeNums(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();

        dfs(ans, root);
        return ans;
    }

    public static void dfs(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    public static int strStr(String haystack, String needle) {
        int ans = -1;
        if (needle.length() > haystack.length()) {
            return ans;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            if (i + needle.length() > haystack.length()) {
                break;
            }
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int q = nums.length - 1;
        int p = nums.length - 2;
        while (p >= 0) {
            if (nums[p] < nums[q]) {
                break;
            }
            p--;
            q--;
        }
        if (p == -1) {
            p = 0;
            q = nums.length - 1;
            while (p <= q) {
                int temp = nums[p];
                nums[p++] = nums[q];
                nums[q--] = temp;
            }
            return;
        }
        int y = nums.length - 1;
        while (y >= q) {
            if (y == q) {
                int temp = nums[p];
                nums[p] = nums[y];
                nums[y] = temp;
                break;
            }
            if (nums[y] > nums[p]) {
                int temp = nums[p];
                nums[p] = nums[y];
                nums[y] = temp;
                break;
            }
            y--;
        }

        p = nums.length - 1;
        while (q <= p) {
            int temp = nums[p];
            nums[p--] = nums[q];
            nums[q++] = temp;
        }
        return;
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] < nums[mid]) {  //[4,5,6,7,8,1,2,3]
                if (nums[0] < target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {  //[6,7,8,1,2,3,4,5]
                if (nums[mid] < target && target < nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int search = search(arr, 0);
        System.out.println(search);


    }

}

