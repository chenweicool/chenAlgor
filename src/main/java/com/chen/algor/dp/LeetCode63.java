package com.chen.algor.dp;

/**
 * 和62道题类似，只不过需要排除下障碍物
 */
public class LeetCode63 {
    /**
     * 使用动态规划来解决这个问题
     *
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 起点和重点是否有障碍物
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
              return 0;
        }
        // 声明一个数组，存储到达终点的
        int[][] dp = new int[m][n];

        // 初始化第一个元素
        dp[0][0] = 1;

        // 因为初始化元素了，所以起始位置从第一个开始
        for (int i = 1; i < m; i++) {
            dp[i][0] = (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;
        }
        // 初始化第一行
        for(int j  =1; j < n; j++){
            dp[0][j] = (dp[0][j - 1] == 1 && obstacleGrid[0][j] == 0) ? 1 : 0;
        }

        // 动态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        // 返回终点路径数量
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
