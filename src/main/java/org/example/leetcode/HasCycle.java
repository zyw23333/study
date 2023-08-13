package org.example.leetcode;

import org.example.configuration.ListNode;

/**
 * leetcode hot-100 141
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        boolean result = false;
        ListNode numb = new ListNode(1);
        numb.next = head;
        ListNode fast = numb, slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                result = true;
                break;
            }
            fast = fast.next;
            slow = slow.next;
            if (slow == null) {
                break;
            }
            slow = slow.next;
        }
        return result;
    }
}
