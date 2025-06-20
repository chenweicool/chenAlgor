package com.chen.algor.dp;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 */
public class LeetCode152 {


    /**
     * 动态转移方程
     * max_ending_here = Math.max(nums[i], max_ending_here * nums[i]);
     * min_ending_here = Math.min(nums[i], min_ending_here * nums[i]);
     * 特别注意，当num[i]为负数时，必须交换最大和最小值，这是因为负数最小对应的值越大，
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max_ending_here = nums[0];
        int min_ending_here = nums[0];
        int max_result = nums[0];

        // 从第一个元素进行 遍历
        for (int i = 1; i < nums.length; i++) {
            // 考虑负数
            if (nums[i] < 0) {
                 int temp = max_ending_here;
                 max_ending_here = min_ending_here;
                 min_ending_here = temp;
            }
            max_ending_here = Math.max(nums[i], max_ending_here * nums[i]);
            min_ending_here = Math.max(nums[i], min_ending_here * nums[i]);

            max_result = Math.max(max_result, max_ending_here);
        }
        return max_result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode152().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
