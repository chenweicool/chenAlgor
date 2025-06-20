package com.chen.algor.number;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class LeetCode168 {

    /**
     * 使用进制转换
     * 因为这个是从1开始的
     * 核心思想是除基取余
     */
    public String convertToTitle(int numbers) {
        StringBuilder sb = new StringBuilder();

        while (numbers > 0) {
              numbers--;
              char c = (char) ('A' + numbers % 26);
            sb.append(c);
            numbers  /= 26;
        }
        return sb.reverse().toString();
    }

    // 通用转换进制的方法，‘除基取余’
    public String convertToNegativeBase(int numbers, int base) {
        boolean negative = numbers < 0;
        StringBuilder sb = new StringBuilder();
        numbers = Math.abs(numbers);

        while (numbers > 0) {
             int remainder = numbers % base;
            if (remainder < 10) {
                sb.append((char) ('0' + remainder));
            }else{
                sb.append((char) ('A' + remainder - 10));  // 兼容16进制
            }
            numbers /= base;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new LeetCode168().convertToTitle(701));
        System.out.println(new LeetCode168().convertToNegativeBase(10,2));
   }
}
