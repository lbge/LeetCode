package com.company;


import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        if (list.size() == 0) {
            throw new RuntimeException("数组为空");
        }
        list.remove(list.size() - 1);
    }

    public int top() {
        if (list.size() == 0) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int n = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < n) {
                n = list.get(i);
            }
        }
        return n;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
