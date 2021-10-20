package com.company.LinkedList;

public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode pre = dumpy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int i = curr.val;
                while (curr != null && curr.val == i){
                    curr = curr.next;
                }
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return dumpy.next;
    }
}
