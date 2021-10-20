package com.company.LinkedList;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curr = null;
        for (int i = 0; i < lists.length; i++) {
            curr = merge(curr, lists[i]);
        }
        return curr;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l1 : l2;
        return pre.next;
    }
}
