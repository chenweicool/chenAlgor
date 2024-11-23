package com.chen.algor.tree;


/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class LeetCode96 {

    /**
     * 解法同95道题
     * 时间超限了，所以必须适用动态规划来解决这个问题
     * 所以使用动态规划来解决这个问题
     */
    public int numTrees(int n) {
         // 声明一个数组，用来存储结果
        int[] dp = new int[n + 1];
        // 初始值，空子树和单子树都是一种
        dp[0] = 1;
        dp[1] = 1;

        // 进行动态规划
        for (int node = 2; node <= n ; node++) {
            int total = 0;
            for (int root = 1; root <= node; root++) {
                int left = dp[root - 1];  // 左子树种树
                int right = dp[node - root]; // 右子树种树
                total += left * right;
            }
            dp[node] = total;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode96().numTrees(3));
    }
}
