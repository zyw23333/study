package org.example.leetcode;

/**
 * leetcode 43 字符串相乘
 */
public class Multiply {
    public static String multiply(String num1, String num2) {
        if ("0".equalsIgnoreCase(num1) || "0".equalsIgnoreCase(num2)) {
            return "0";
        }
        String result = "";
        char[] char1 = num1.toCharArray(), char2 = num2.toCharArray();
        int length = Math.min(char1.length, char2.length);
        // choose = true then choose num1 as base
        boolean choose = char2.length > length;
        int power = 0;
        for (int i = 1; i <= length; i++) {
            char base = choose ? char1[char1.length - i] : char2[char2.length - i];
            String singleResult = singleMulti(String.valueOf(base), choose ? num2 : num1);
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append(singleResult);
            for (int j = 0; j < power; j++) {
                tempBuilder.append('0');
            }
            result = sumString(result, tempBuilder.toString());
            power += 1;
        }
        return result;
    }

    private static String singleMulti(String base, String factor) {
        StringBuilder result = new StringBuilder();
        int baseNum = base.charAt(0) - '0';
        int overflow = 0;
        for (int i = factor.length() - 1; i >= 0; i--) {
            int tempMultiple = baseNum * (factor.charAt(i) - '0') + overflow;
            overflow = tempMultiple / 10;
            result.insert(0, tempMultiple % 10);
        }
        if (overflow > 0) {
            result.insert(0, overflow);
        }
        return result.toString();
    }

    private static String sumString(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        boolean overflow = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            int sum = str1.charAt(str1.length() - i) - '0' + str2.charAt(str2.length() - i) - '0';
            sum = overflow ? sum + 1 : sum;
            overflow = sum >= 10;
            sb.insert(0, sum % 10);
        }
        if (str1.length() > length) {
            for (int i = str1.length() - 1 - length; i >= 0; i--) {
                int sum = str1.charAt(i) - '0';
                sum = overflow ? sum + 1 : sum;
                overflow = sum >= 10;
                sb.insert(0, sum % 10);
            }
        }
        if (str2.length() > length) {
            for (int i = str2.length() - 1 - length; i >= 0; i--) {
                int sum = str2.charAt(i) - '0';
                sum = overflow ? sum + 1 : sum;
                overflow = sum >= 10;
                sb.insert(0, sum % 10);
            }
        }
        if (overflow) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "10";
        System.out.println(multiply(num1, num2));
    }
}
