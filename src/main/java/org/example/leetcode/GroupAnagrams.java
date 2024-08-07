package org.example.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * leetcode hot-100 49
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] test = new String[]{"bd","aacc"};
        List<List<String>> result = groupAnagrams(test);
        result.forEach(System.out::println);
        // convert result to array
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(3,4));
        int[][] temp = list.stream()
                .map(item -> item.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        System.out.println(Arrays.deepToString(temp));
    }
}
