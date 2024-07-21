package org.example.leetcode;

import java.util.*;

class RandomizedSet {
    private List<Integer> numList;
    private Map<Integer, Integer> numMap;

    public RandomizedSet() {
        numList = new ArrayList<>();
        numMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (numMap.containsKey(val)) {
            return false;
        }
        numList.add(val);
        numMap.put(val, numList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (numMap.containsKey(val)) {
            numList.remove(numMap.get(val).intValue());
            numMap.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        if (numList.size() == 1) {
            return numList.get(0);
        }
        Random random = new Random();
        return numList.get(random.nextInt(numList.size() - 1));
    }

    public static void main(String[] args) {
        RandomizedSet test = new RandomizedSet();
        System.out.println(test.insert(-1));
        System.out.println(test.remove(-2));
        System.out.println(test.insert(-2));
        System.out.println(test.getRandom());
        System.out.println(test.remove(-1));
        System.out.println(test.insert(-2));
        System.out.println(test.getRandom());

    }
}
