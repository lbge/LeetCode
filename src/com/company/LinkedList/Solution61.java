package com.company.LinkedList;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        // 采用寻找倒数第K个节点，截断重新拼接
        if (k == 0 || head == null || head.next == null) {
            // 特殊情况判断
            return head;
        }
        // 计算链表长度
        int len = 1;
        ListNode curr = head;
        while (curr.next != null){
            curr = curr.next;
            len++;
        }
        // 真正需要右移的位置
        int temp = k % len;
        if (temp == 0){
            // 如果旋转的是链表长度的整数倍，相当于不变
            return head;
        }
        ListNode[] arr = findK(head, temp);
        // 将倒数第K+1个链表设为尾节点，倒数第K个链表设为头节点
        ListNode tail = arr[0];
        // 将原链表尾与头链接
        tail.next = head;
        // 从倒数第 K+1 个节点断开
        ListNode newTail = arr[1];
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    // 找到链表倒数第k+1个节点, 由于前置取模，k一定小于链表长度
    public ListNode[] findK(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 返回链表第k+1个节点
        return new ListNode[]{fast,slow};
    }
}
