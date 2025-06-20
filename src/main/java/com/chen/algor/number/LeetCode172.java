package com.chen.algor.number;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
public class LeetCode172 {

    /**
     * 一个尾随的 0 是由乘法中出现的因子 10 造成的，而一个 10 = 2 × 5。
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode172().trailingZeroes(7));
    }
}
