package com.chen.algor.number;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class LeetCode69 {
    // 使用二分查找来实现
    public static int power(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        // 使用二分法进行查找
        int left = 0;
        int right = x,result = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (mid == x / mid) {
                 return mid;
            } else if (mid < x / mid) {
                  result = mid;
                  left = mid+1;
            }else{
                right = mid -1;
            }
           }
        return  result;
        }

    public static void main(String[] args) {
        System.out.println(power(8));

    }
}
