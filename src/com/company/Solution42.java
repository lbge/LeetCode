package com.company;

import java.util.Stack;

public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();//栈中存放数组下标
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //此处是while，将这一高度前对应的池子全部遍历完
                int top = stack.pop();
                if (stack.isEmpty()) {
                    //无法形成池子，跳过
                    break;
                }
                int left = stack.peek();
                int x = i - left - 1;//池子的宽度
                int y = Math.min(height[i], height[left]) - height[top];//池子的高度
                res += x * y;//当前池子的面积
            }
            stack.push(i);
        }
        return res;
    }
}
