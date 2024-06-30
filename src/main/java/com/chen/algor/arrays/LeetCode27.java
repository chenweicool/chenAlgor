package com.chen.algor.arrays;

/**
 * 移除元素
 * 题目描述
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * 解题思路: 双指针
 */
public class LeetCode27 {

    public int removeElement(int[] nums,int target) {
        if (nums == null || nums.length == 0) {
             return 0;
        }
        // 声明一个慢指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if ( nums[fast] != target) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        System.out.println(new LeetCode27().removeElement(nums, 1));
    }

}
