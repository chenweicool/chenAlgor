package com.chen.algor.string;

import org.omg.SendingContext.RunTime;

/**
 * 整数反转
 * 需要给出一个整数，输出他的反转数
 * 比如 123 输出就是321
 * 比如 -123  输出就是-321  也就是符号不反转
 *
 * 这个题的关键在于如何解决溢出的问题
 * 使用推到公式进行计算的，
 *一个进位，一个出位，比较厉害了
 *这里有个人讲的比较好，
 *
 * 就是怎么拿到末尾数字，取模，就可以拿到末尾数字，一次除10就可以了
 */
public class LeetCode7 {

    // 官方题解
    public int reverse(int i) {
         int rev = 0;
        while (i != 0) {
              // 溢出条件判断
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int d = i % 10;
            i /=10;
            rev = rev * 10 +d;
        }
        return rev;
    }

    public static void main(String[] args) {
        int reverse = new LeetCode7().reverse(123);
        System.out.println(reverse);
    }
}
