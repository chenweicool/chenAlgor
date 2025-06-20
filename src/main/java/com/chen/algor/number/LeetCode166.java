package com.chen.algor.number;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述:
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 */
public class LeetCode166 {

    // 这个题目，核心是处理小数的余数部分
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // 处理绝对值部分
        long num = numerator == Integer.MIN_VALUE ? (long) Integer.MAX_VALUE + 1 : Math.abs(numerator);
        long den = denominator == Integer.MIN_VALUE ? (long)Integer.MAX_VALUE + 1 : Math.abs(denominator);
        // 获得整数部分
        result.append(num / den);

        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        // 处理循环余数情况
        // 声明一个map结构
        Map<Long,Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            // 如果余数重复，说明小数部分开始了循环
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            }
            // 常除法
            remainderMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode166().fractionToDecimal(-2147483648,1));
    }
}
