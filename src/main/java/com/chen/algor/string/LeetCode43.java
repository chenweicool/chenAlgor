package com.chen.algor.string;

/**
 * 题目描述；
 * 两个字符串相乘
 * https://leetcode.cn/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class LeetCode43 {
    /**
     * 解决方法：
     * 1 手动模拟小学乘法进行处理，从地位到高位进行模拟处理
     * @param num1
     * @param nums2
     * @return
     */
    public String multiply(String num1, String nums2) {
         // 不能使用整数相乘，因为容易溢出
        int n = num1.length(),m = nums2.length();
        // 初始化数组，存储中间值
        int[] result = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (nums2.charAt(j) - '0');
                // 加它的余数
                int sum = mul + result[i + j + 1];

                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
        // 遍历reslr
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            if (i == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String nums2 = "456";
        System.out.println(new LeetCode43().multiply(num1, nums2));
    }
}
