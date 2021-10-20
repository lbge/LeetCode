package com.company.LinkedList;

public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        int temp = k % len;
        if (temp == 0) {
            return head;
        }
        ListNode tail = cur;
        tail.next = head;
        for (int i = 0; i < len - temp + 1; i++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
