package com.chen.algor.backtrace;

/**
 * 使用算法实现指数计算
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class LeetCode50 {

    // 这个算法溢出了，使用奇数和偶数进行优化，不能暴力解决，减少执行次数
    // 考虑负数边界条件，有些时候，还是需要进行边界条件的特殊判断的
    public double myPow(double m, int n) {
        if (n == 0) {
            return 1;
        }
        // 处理 n 为负数的情况
        if (n < 0) {
            m = 1 / m;
            // 防止溢出
            if(n == Integer.MIN_VALUE){
                if(m == -1){
                    return 1;
                }
                n = n+1;
            }
            n = -n;
        }

        double result = 1;
        while (n > 0) {
            // 如果 n 是奇数，乘上额外的 m
            if (n % 2 == 1) {
                result *= m;
            }
            // m = m^2, n = n / 2
            m *= m;
            n /= 2;
        }

        return result;
    }

    public double myPowV2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            // 防止溢出
            if(n == Integer.MIN_VALUE){
                if(x == -1){
                    return 1;
                }
                n = n+1;
            }
            n = -n;
        }
        // 递归的终止条件
        if (n == 0) {
            return 1;
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode50().myPowV2(-1.00000, -2147483648));
    }

}
