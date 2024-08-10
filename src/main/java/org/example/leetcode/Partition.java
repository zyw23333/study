package org.example.leetcode;

import org.example.configuration.ListNode;

import java.util.Arrays;

/**
 * partition the linked list by number x
 * number less than x should be in the left,
 * and number greater than x should be in the right
 * left and right should keep the original order
 * @Date 2024/8/8
 * @Author zhang
 * If any question, please mail zhang_yiwei@trip.com
 **/
public class Partition {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode insertHead = dummy;
        ListNode before = dummy;
        boolean flag = true;
        while (head != null) {
            if (head.val < x) {
                if (before == dummy) {
                    before = before.next;
                    insertHead = insertHead.next;
                    head = head.next;
                    continue;
                }
                // insert after head
                ListNode temp = head.next;
                before.next = head.next;
                head.next = insertHead.next;
                insertHead.next = head;
                insertHead = head;
                if (flag) {
                    before = before.next;
                }
                head = temp;
            } else {
                before = before.next;
                head = head.next;
                flag = false;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = partition(head, 4);
        Arrays.asList(new int[]{1,3,4});
    }
}
