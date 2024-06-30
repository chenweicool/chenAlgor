package com.chen.algor.dp;

/**
 * 打家劫舍问题
 * 动态规划，
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 解决重复的问题
 *
 */
public class LeetCode198 {
    /**
     * 动态规划，最主要是状态转移
     * 对于第i个房子，右两个选项
     * 1 不偷第i个房子，最大金额就是 dp[i-1]
     * 2  偷第i个房子，就不能偷第i-1个房子，最大金额就是 dp[i-2] + num[i]
     * 动态转移方程就是:
     * dp[i] = Math.max(dp[i-1],dp[i-2]+ num[i])
     *
     * 初始条件 如果第一个房子 dp[0] = nums[0];
     * 有两个房子  dp[1] = max[num[0],num[1]]
     * * @param nums
     * @return
     */
    public int rob(int[] nums){
        if (nums == null || nums.length == 0) {
             return 0;
        }
        int n = nums.length;
        if (n == 1) {
             return nums[0];
        }
        // 初始化数组
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 遍历数组，进行状态转移
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    // 第二种方法，优化，不需要数组
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return  0;
        }
        if(nums.length == 1){
            return  nums[0];
        }

        int pre1 = 0;
        int pre2 = 0;
        for (int num : nums) {
            int current = Math.max(pre1, pre2 + num);
            pre2 = pre1;
            pre1 = current;
        }
        return pre1;
    }

    public static void main(String[] args) {
        int[] robHourSource = {1,3,5,6,2};
        System.out.println(new LeetCode198().rob(robHourSource));
        System.out.println(new LeetCode198().rob2(robHourSource));
    }
}
