package com.chen.algor.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用递归回朔的方法来解决
 * 题目描述
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 这个题没有理解
 */
public class LeetCode22 {

    public List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        brackBack(result, "", 0, 0, n);
        return  result;
    }

    private void brackBack(List<String> result, String current, int open, int close, int max) {
        // 字符串长度等于n的2倍就结束
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        // 尝试加一个左括号
        if (open < max) {
            brackBack(result, current + "(", open + 1, close, max);
        }
        // 尝试加一个右括号
        if (close < open) {
            brackBack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        List<String> generate = new LeetCode22().generate(3);
        for (String s : generate) {
            System.out.println(s);
        }
    }

}
