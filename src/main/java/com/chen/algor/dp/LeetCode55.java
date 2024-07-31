package com.chen.algor.dp;

/**
 * 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *使用贪心算法
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
         int maxMatch = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxMatch) {
                 return false;
            }
            maxMatch = Math.max(maxMatch, i + nums[i]);
            // 如果到达最远距离大于等于数组，说明是可以跳到的
            if (maxMatch >= nums.length - 1) {
                 return true;
            }
        }
        // 遍历结束，还是没有到的，那就返回false
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2, 0, 1, 1, 4};
        System.out.println(new LeetCode55().canJump(nums));
    }
}
