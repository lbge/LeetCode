package com.company;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                //当新元素大于队尾元素时，移除队尾元素
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                //窗口左侧移出去的元素如果等于队列头部的元素，则移除队头元素
                deque.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }
}
