package org.example.leetcode;


import org.example.configuration.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overFlow = 0;
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            // sum
            int sum = (l1.val + l2.val + overFlow) % 10;
            overFlow = l1.val + l2.val >= 10 ? 1 : 0;
            ListNode tempNode = new ListNode(sum);
            current.next = tempNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            int value = l1 == null ? l2.val : l1.val;
            int sum = (value + overFlow) % 10;
            overFlow = value + overFlow >= 10 ? 1 : 0;
            ListNode tempNode = new ListNode(sum);
            current.next = tempNode;
            current = current.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (overFlow > 0) {
            current.next = new ListNode(overFlow);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(3, null);
        ListNode t2 = new ListNode(7, null);
        t1.next = t2;
        ListNode t4 = new ListNode(9, null);
        ListNode t5 = new ListNode(2, null);
        t4.next = t5;
        ListNode result = addTwoNumbers(t1, t4);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
