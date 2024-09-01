package com.chen.algor.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 */
public class LeetCode62 {

    /**
     * 使用动态规划来解决这
     * 1 声明dp[i][j] 表示从[0][0]到达 [i][j]的总路径数据
     * 2 机器人只能向右或者向下移动，因此，到达（i,j）路径上方(i-1,j) 或者左方（i，j-1）之和
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3 初始化：
     *  对于第一行dp[0][j] 只能从左边过来，dp[0][j]  =1;
     *  对于第一列dp[i][0],只能从上面走过来 dp[i][0] = 1;
     */
    public static int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];

        // 初始化路径第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //初始化第一行
        for (int j = 0; j <n; j++) {
            dp[0][j] = 1;
        }
        //动态转移方程
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("Unique paths: " + uniquePath(m, n));
    }
}
