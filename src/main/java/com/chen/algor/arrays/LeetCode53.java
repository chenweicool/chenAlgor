package com.chen.algor.arrays;

/**
 * 数组的第53道题，返回最大子数组之和
 * 还有部分动态规划
 */
public class LeetCode53 {
    // 使用Kadane's Algorithm算法来解决这个问题，
    // 问题核心是，使用最大连续的子数组，连续的子数组，这些比较重要
    public int maxSubArray(int[] nums) {
        int currentSun = nums[0];
        int maxSum = nums[0];

        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            currentSun = Math.max(nums[i], currentSun + nums[i]);

            maxSum = Math.max(maxSum, currentSun);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new LeetCode53().maxSubArray(nums));
    }
}
