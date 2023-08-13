package org.example.leetcode;

import org.example.configuration.ListNode;

/**
 * leetcode hot-100 206
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
//        head = head.next;
        while(head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head.next.next = temp;
//            head = head.next;
            head = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(3);
        ListNode test3 = new ListNode(4);
        test.next = test1;
        test1.next = test2;
        test2.next = test3;
        reverseList(test);
    }
}
