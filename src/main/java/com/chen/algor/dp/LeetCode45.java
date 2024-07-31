package com.chen.algor.dp;

/**
 * 跳跃游戏
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 你的目标就是使用最少的次数跳到数组末尾
 *
 */
public class LeetCode45 {
    /**
     * 使用动态规划来解决这个问题，
     *动态转移方程就是
     * fastEest =Math.max(farthest,i+num[i]);
     * 遍历数组，进行解决
     * 声明三个变量，一个表示当前位置跳到最远举例farthest ,
     * 遍历数组，如果到达，currentEnd表示当前的结束位置
     * jumps表示跳跃次数
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
     int farthest = 0;
     int jumps = 0;
        int currentEnd = 0;
     // 遍历数组，这里必须是-1 是因为最差到倒数最后一个元素
        for (int i = 0; i < nums.length-1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // 更新能到达的最远位置
            if (i == currentEnd) {  // 到达当前跳跃的结束位置
                jumps++;
                currentEnd = farthest; // 更新结结束位置
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 1, 4};
        System.out.println(new LeetCode45().jump(nums));
    }
}
