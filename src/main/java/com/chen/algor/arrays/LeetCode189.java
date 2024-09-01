package com.chen.algor.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class LeetCode189 {
    /**
     * 这个思路绝了
     */
    public int[] rotate(int[] nums, int k) {
         // 声明一个数字长度
        int length = nums.length;
        k = k % length;

        // 旋转整个数组
        roserver(nums,0,length-1);
        //旋转前k个数组
        roserver(nums,0,k-1);
        // 旋转k之后的数组
        roserver(nums, k, length - 1);
        return nums;
    }

    private void roserver(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(new LeetCode189().rotate(nums, 3)));

    }
}
