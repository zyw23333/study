package org.example.leetcode;


import org.example.configuration.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int forward = 0; //表示进位
        ListNode temp = null;
        ListNode result = null;
        while(l1 != null && l2 != null) {
            if (result == null) {
                temp = new ListNode();
                result = temp;
            } else {
                temp.next = new ListNode();
                temp = temp.next;
            }
            temp.val = (l1.val + l2.val + forward) % 10;
            forward = (l1.val + l2.val + forward) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        int first = forward;
        if (l1 != null) {
            temp.next = l1;
            while (l1 != null && forward != 0) {
                first = (l1.val + forward) / 10;
                l1.val = (l1.val + forward) % 10;
                forward = first;
                temp = l1;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            temp.next = l2;
            while (l2 != null && forward != 0) {
                first = (l2.val + forward) / 10;
                l2.val = (l2.val + forward) % 10;
                forward = first;
                temp = l2;
                l2 = l2.next;
            }
        }
        if (forward == 1) {
            temp.next = new ListNode(1, null);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(9, null);
        ListNode t2 = new ListNode(9, null);
        ListNode t3 = new ListNode(9, null);
        t1.next = t2;
        t2.next = t3;
        ListNode t4 = new ListNode(9, null);
        ListNode t5 = new ListNode(9, null);
        ListNode t6 = new ListNode(9, null);
        ListNode t7 = new ListNode(9, null);
        ListNode t8 = new ListNode(9, null);
        t4.next = t5;
        t5.next = t6;
        t6.next = t7;
        t7.next = t8;
        ListNode result = addTwoNumbers(t1, t4);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
