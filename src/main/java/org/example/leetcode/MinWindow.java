package org.example.leetcode;

import java.util.HashMap;

/**
 * give two string s & t, find the min window in s which will contain all the characters in t
 * @Date 2024/8/6
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class MinWindow {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dict.computeIfPresent(t.charAt(i), (k, v) -> v+1);
            dict.computeIfAbsent(t.charAt(i), k -> 1);
        }
        int start = 0, end = 0, tempSize = dict.size();
        String result = "";
        while (end < s.length() || tempSize <= 0) {
            if (tempSize > 0) {
                if (dict.containsKey(s.charAt(end)) && dict.get(s.charAt(end)) == 1) {
                    tempSize -= 1;
                }
                dict.computeIfPresent(s.charAt(end), (k, v) -> v - 1);
                end++;
                continue;
            } else if (tempSize == 0) {
                while (tempSize == 0) {
                    String tempResult = s.substring(start, end);
                    if (result.isEmpty() || tempResult.length() < result.length()) {
                        result = tempResult;
                    }
                    dict.computeIfPresent(s.charAt(start), (k, v) -> v + 1);
                    if (dict.containsKey(s.charAt(start)) && dict.get(s.charAt(start)) == 1) {
                        tempSize += 1;
                    }
                    start++;
                }
            }
        }
        return result;
    }

    private static boolean isAnagram(String src, String dest) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < src.length(); i++) {
            countMap.computeIfPresent(src.charAt(i), (k, v) -> v + 1);
            countMap.computeIfAbsent(src.charAt(i), k -> 1);
        }
        for (int i = 0; i < dest.length(); i++) {
            if (!countMap.containsKey(dest.charAt(i))) {
                return false;
            }
            countMap.computeIfPresent(dest.charAt(i), (k, v) -> v == 1 ? null : v - 1);
        }
        return countMap.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        String test = "aaa";
    }
}
