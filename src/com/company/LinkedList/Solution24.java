package com.company.LinkedList;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 构造辅助头节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode curr = pre;
        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;
            // 交换两节点
            node1.next = node2.next;
            node2.next = node1;
            curr.next = node2;
            // 更新curr的位置
            curr = node1;
        }
        return pre.next;
    }
}
