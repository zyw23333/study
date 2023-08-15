package org.example.leetcode;

import org.example.configuration.ListNode;

public class TestSumCode {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0,b = 0;
        int maxFlag = -1;
        int flag = 0;
        while (l1 != null){
            a  += l1.val*(int)Math.pow(10,flag);
            l1 = l1.next;
            flag++;
        }
        maxFlag = Math.max(maxFlag, flag);
        flag = 0;
        while (l2 != null){
            b += l2.val * (int)Math.pow(10,flag);
            l2 = l2.next;
            flag++;
        }
        maxFlag = Math.max(maxFlag, flag);
        a = a+b;
        ListNode ans = new ListNode();
        ListNode temp = new ListNode();
        while (maxFlag > 0) {
            ans = new ListNode();
            temp.val = a / (int)Math.pow(10,maxFlag - 1);
            a = a % (int)Math.pow(10,maxFlag - 1);
            maxFlag--;
            ans.next = temp;
            temp = ans;
        }
        return ans.next;
    }

    public static ListNode foo(ListNode t1, ListNode t2) {
       ListNode pre = new ListNode();
       ListNode temp = pre;
       pre.next = t1;
       int increase = 0;
       while (t1 != null || t2 != null){
           ListNode node1 = t1 == null ? new ListNode(0) : t1;
           ListNode node2 = t2 == null ? new ListNode(0) : t2;
           temp.next = new ListNode((node1.val + node2.val +increase)  % 10 );
           increase = (node1.val + node2.val + increase) / 10;

           t1 = node1.next; t2 = node2.next; temp = temp.next;
       }
       if (increase != 0) {
           temp.next = new ListNode(increase);
       }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(9);
//        ListNode third = new ListNode(3);
        first.next =second;
//        second.next = third;
        ListNode fourth = new ListNode(9);
//        ListNode fifth = new ListNode(6);
//        ListNode sixth = new ListNode(4);
//        fourth.next = fifth;
//        fifth.next = sixth;
        addTwoNumbers(first, fourth);
    }
}
