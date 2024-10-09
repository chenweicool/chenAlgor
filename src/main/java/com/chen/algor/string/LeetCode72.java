package com.chen.algor.string;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例：
 *  示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class LeetCode72 {

    public static int findMinDistance(String a, String b) {
        // 声明一个动态规划数组
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        // 初始化数组
        for (int i = 0; i <= m; i++) {
             dp[i][0] = i;
        }
        for(int j = 0; j<= n; j++){
            dp[0][j] =  j;
        }

        // 动态转移方程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    // 不需要操作
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    // 需要处理下，取最小值进行+1就是操作数，
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMinDistance("horse", "ros"));
    }
}
