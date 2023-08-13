package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode hot-100 406
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        List<List<Integer>> content = Arrays.stream(people)
                .map(i -> Arrays.stream(i).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        content.sort(((o1, o2) -> Objects.equals(o1.get(1), o2.get(1)) ? o1.get(0) - o2.get(0) : o1.get(1) - o2.get(1)));
        int[][] result = new int[content.size()][2];
        int count = 0;
        for (List<Integer> temp : content) {
            result[count++] = temp.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, String> test = new HashMap<>();
        Integer number = 1;
        System.out.println(number.hashCode());
        number = 2;
        System.out.println(number.hashCode());
        test.put(number, "aaa");
        test.put(1, "bbb");
        test.put(3, "ccc");
        for (Integer i : test.keySet()) {
            System.out.println(i);
            System.out.println(test.get(i));
        }
        test.put(1, "ddd");
        for (Integer i : test.keySet()) {
            System.out.println(i);
            System.out.println(test.get(i));
        }
        System.out.println();
    }
}
