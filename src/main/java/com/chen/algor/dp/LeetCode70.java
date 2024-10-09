package com.chen.algor.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class LeetCode70 {

    /**
     * n的结成，使用动态规划
     * 动态规划：
     * 1 列出初始条件，每层楼梯都是第一层和第二层的之和
     * 如果只有一阶，那就一种方法，如果有两阶，，那就是2种方法
     * 2 动态转移方程
     * dp[i] = dp[i-1]+dp[i-2]
     * 返回dp[n];
     */
    public static int climbStairs(int n) {
        if (n == 1) {
             return 1;
        }
        // 声明动态存储条件
        int[] dp = new int[n+1];

        // 声明初始条件
        dp[1] = 1;
        dp[2] = 2;

        // 动态转移方程,这里有问题
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
