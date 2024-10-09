package com.chen.algor.dp;

/**
 * 给定两个单词 word1 和 word2 ，返回使得word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * 允许删除,但是不允许插入
 */
public class LeetCode583 {

    public   int minDistance(String a, String b) {
        int longLength = longstCommonSub(a, b);
        return a.length() + b.length() - 2 * longLength;
    }

    // 返回最长公共子序列长度
    public int longstCommonSub(String a, String b) {
         int m = a.length();
        int n = b.length();

        // 声明动态数组
        int[][] dp = new int[m + 1][n + 1];

        // 进行填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("Minimum deletions to make word1 and word2 the same: " + new LeetCode583().minDistance(word1, word2));
    }
}
