package com.company.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head; // 伪头节点，值为0

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index < 0)
            index = 0;// 索引为负插到头结点上
        size++; // 注意size及时更新
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //pre此刻为添加点的前一节点
        ListNode add = new ListNode(val);
        add.next = pre.next;
        pre.next = add;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        size--; // 注意size及时更新
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
