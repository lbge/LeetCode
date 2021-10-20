package com.company.LinkedList;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 此处不必再定义哑节点，因为最终会从后往前输出所有节点
        // 此处不必定义pre.next = curr，因为pre和curr之间是断开的
        ListNode curr = head;
        while (curr != null) { // 此处不是判断curr.next不为空，最终返回的是pre
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            // 每一轮结束后，pre和curr之间是断开的，最终返回的是pre
        }
        return pre;
    }
}
