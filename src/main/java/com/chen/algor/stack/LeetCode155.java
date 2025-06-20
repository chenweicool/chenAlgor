package com.chen.algor.stack;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class LeetCode155 {

    static class MinStack {

       private  Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            // 如果当前最小栈为空，或者当前值等于最小栈顶元素，更新最小栈
            if(minStack.isEmpty() || val <= minStack.peek()){
                  minStack.push(val);
            }
        }

        public void pop() {
           if(stack.peek().equals(minStack.peek())){
               minStack.pop();
           }
            stack.pop();
        }

        public int top() {
             return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(-1);
        System.out.println(minStack.getMin());
    }
}
