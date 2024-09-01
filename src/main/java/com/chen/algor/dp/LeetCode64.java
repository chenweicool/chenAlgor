package com.chen.algor.dp;

/**
 * 最小路径之和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *经典的动态规划的题目：
 * 1  声明数组dp[i][j]表示从dp[0][0]到 dp[i][j]最小的路径之和
 * 2  动态转移方程
 * dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1])+girid[i][j];
 */
public class LeetCode64 {

    public static int minPathSum(int[][] grids) {
        int m = grids.length;
        int n = grids[0].length;

        // 声明一个数组
        int[][] dp = new int[m][n];

        // 初始化数组第一个节点
        dp[0][0] = grids[0][0];
        // 初始化第一个列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grids[i][0];
        }
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grids[0][j];
        }

        // 进行动态方程转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grids[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 第二种方法，不需要浪费额外空间的解决方法
    public int minPathSumV2(int[][] grid) {
        // 先获取数组大小，并声明数组大小，
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grids = {{1,3,1}, {1,5,1},{4,2,1}};
        System.out.println(minPathSum(grids));
    }
}
