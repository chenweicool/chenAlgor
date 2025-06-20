package com.chen.algor.arrays;


import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class LeetCode167 {

    /**
     * 使用双指针来解决这个问题
     * 小标要大于1，所以需要加1
     */
    public int[] twoSum(int[] nums, int target) {
         int left = 0,  right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                 left ++;
            }else{
                right--;
            }
        }
        return new int[]{-1, 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode167().twoSum(new int[]{2, 3, 5, 9}, 7)));
    }
}
