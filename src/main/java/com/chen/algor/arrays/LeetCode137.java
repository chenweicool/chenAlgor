package com.chen.algor.arrays;

/**
 * 题目描述
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 * 遇到这种问题，基本解决方法就是，使用位运算解决比较好
 */
public class LeetCode137 {

    /**
     * 使用常数算法来解决
     * 使用实现线性复杂度和常数级空间是这个问题难点
     * @param nums
     */
    public int singleNumber(int[] nums) {
        int ones = 0; int twos = 0;
        for (int num : nums) {
            twos |= ones & num;
            ones ^= num;

            int threes = ones & twos;
            ones &= ~threes;  // 清除在 ones 中出现三次的位
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode137().singleNumber(new int[]{1, 1,1,2,2,2,0}));
    }
}
