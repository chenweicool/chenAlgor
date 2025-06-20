package com.chen.algor.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * 逆波兰的求解
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class LeetCode150 {

    // 使用栈来实现，遇到符号出栈，进行计算，然后进行压栈
    public int evalERN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                     stack.push(stack.pop() + stack.pop());
                     break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                     b = stack.pop();
                     a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));

            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode150 leetCode150 = new LeetCode150();
        System.out.println(leetCode150.evalERN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
