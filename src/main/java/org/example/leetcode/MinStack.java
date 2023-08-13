package org.example.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * leetcode hot-100 155
 */
public class MinStack {
    private PriorityQueue<Integer> sort;
    private LinkedList<Integer> data;
    public MinStack() {
        sort = new PriorityQueue<>();
        data = new LinkedList<>();
    }

    public void push(int val) {
        data.offerFirst(val);
        sort.offer(val);
    }

    public void pop() {
        Integer value = this.data.pollFirst();
        sort.remove(value);
    }

    public int top() {
        return data.peekFirst();
    }

    public int getMin() {
        return sort.peek();
    }
}
