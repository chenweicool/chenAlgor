package com.chen.algor.string;

import java.util.Arrays;

/**
 * 数字加1
 * 66. 加一
 *
 代码


 测试用例
 测试结果
 测试结果
 66. 加一
 简单
 相关标签
 相关企业
 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。
 示例 1：
 输入：digits = [1,2,3]
 输出：[1,2,4]
 解释：输入数组表示数字 123。
 示例 2：
 输入：digits = [4,3,2,1]
 输出：[4,3,2,2]
 解释：输入数组表示数字 4321。
 示例 3：
 输入：digits = [0]
 输出：[1]
 */
public class LeetCode66 {

    /**
     * 理解这个题了
     * 这个题就是相待把数组看成一个数字，然后统一加1，然后重新分配到数组中，根据最高位一次拆解
     * 比如
     * 99
     * 分配前[9，9]
     * 加1 之后，
     * 就是 100
     * 也就是表示
     * [1,0,0]
     * 考虑下，整数越界的情况，先声明一个字符串，把数组整体，然后遍历
     */
    public static  int[] plusOne(int[] digits) {
        // 从最后一位开始处理
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                 digits[i]++;
                 return digits;
            }
            // 否则末尾置为0；
            digits[i]  =0;
        }
        // 处理下全部为9999情况,只需要
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {

        int[] digits1 = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits1)));  // 输出: [1, 2, 4]

        int[] digits2 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits2)));
    }
}
