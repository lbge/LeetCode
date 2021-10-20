package com.company;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int pop1, pop2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 + pop1);
                    break;
                case "-":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 - pop1);
                    break;
                case "*":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 * pop1);
                    break;
                case "/":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 / pop1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
