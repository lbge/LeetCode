package com.company.LinkedList.leetcode142;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// 方法一，通过Set集合查询
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return null;
    }
}

//方法二、快慢指针
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //此处判断head可忽略，若为空跳过循环直接返回null。
        if (head == null) {
            return null;
        }
        //加上判断可以省略下方创建快慢指针造成空间消耗
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            //加入判断，防止报错
            if (fast.next!= null){
                fast = fast.next.next;
            }else {
                // 为空则为单链表，无环
                return null;
            }
            if(slow == fast){
                // 相遇有环，计算入环起点
                ListNode flag = head;
                while (flag != slow ){
                    flag = flag.next;
                    slow = slow.next;
                }
                return flag;
            }
        }
        return null;
    }
}
