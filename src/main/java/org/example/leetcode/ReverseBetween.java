package org.example.leetcode;

import org.example.configuration.ListNode;

/**
 * reverse node between m pos and n pos in a linked-list
 * @Date 2024/8/8
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) {
            return head;
        }
        int count = 1;
        ListNode dummy = new ListNode(-1, head);
        ListNode before = dummy;
        while (count < left && head != null) {
            head = head.next;
            count += 1;
            before = before.next;
        }
        while (count < right) {
            headInsert(before, head, head.next);
            count += 1;
        }
        return dummy.next;
    }

    private void headInsert(ListNode before, ListNode current, ListNode after) {
        if (after == null) {
            return;
        }
        current.next = after.next;
        after.next = before.next;
        before.next = after;
    }
}
