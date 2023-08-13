package org.example.Service;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt(), expect = scanner.nextInt();
        Map<Integer, Integer> statistics = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                int day = scanner.nextInt();
                statistics.put(day, statistics.getOrDefault(day, 0) + 1);
            }
        }
        int result = -1;
        for (Integer day : statistics.keySet()) {
            if (statistics.get(day) == expect) {
                if (result == -1) {
                    result = day;
                }
                else {
                    result = Math.min(result, day);
                }
            }
        }
        System.out.println(result == -1 ? 0 : result);
    }
}
