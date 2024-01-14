package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 13 罗马数字转整数
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer temp = dict.get(chars[i]);
            if (i < chars.length - 1) {
                Integer next = dict.get(chars[i + 1]);
                if (next > temp) {
                    result += next - temp;
                    i += 1;
                    continue;
                }
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "XI";
        System.out.println(romanToInt(input));
    }
}
