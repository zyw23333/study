package org.example.Service;

import org.example.configuration.ListNode;

public class Test {
    public static ListNode reverse(ListNode head, int m, int n) {
        ListNode copyHead = head;
        ListNode other = new ListNode(-1); //dummy
        ListNode dummy = new ListNode(-2);
        dummy.next = head;
        ListNode start = new ListNode(-3), end = new ListNode(-4);
        int count = 0;
        boolean flag = true;
        while(head != null) {
            count += 1;
            if (count >= m && count < n) {
                //start record
                ListNode temp = new ListNode(head.val);
                temp.next = other.next;
                other.next = temp;
                if (flag) {
                    //record start and tail
                    start = dummy;
                    flag = false;
                    end = temp;
                }
            } else if (count == n) {
                //start merge
                ListNode temp = new ListNode(head.val);
                temp.next = other.next;
                other.next = temp;
                start.next = other.next;
                end.next = head.next;
                break;
            }
            head = head.next;
            dummy = dummy.next;
        }
        return copyHead;
    }
}
