package com.company.LinkedList;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode dumpy1 = new ListNode(0);
        ListNode curr1 = dumpy1;
        ListNode dumpy2 = new ListNode(0);
        ListNode curr2 = dumpy2;
        while (curr != null) {
            if (curr.val < x) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else {
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        // 新增一条链表要定义尾节点，否则链表没有结束
        curr1.next = dumpy2.next;
        curr2.next = null;
        return dumpy1.next;
    }
}
