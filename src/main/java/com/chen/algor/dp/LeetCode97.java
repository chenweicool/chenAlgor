package com.chen.algor.dp;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空
 * 子字符串
 */
public class LeetCode97 {

    /**
     * 使用动态规划来解决
     */
    public boolean isInterleave(String s1, String s2, String s3) {
         int m = s1.length();
        int n = s2.length();

        if (s3.length() != m + n) {
            return false;
        }

        // 动态规划，声明一个数组，表示s1和s2前i和j是否可以组成动态字符串
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        // 初始化行，
        for (int i = 1; i <= m; i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i-1);
        }

        // 初始化列
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        //进行动态规划
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (
                                dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                        );
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LeetCode97 solution = new LeetCode97();
        String s1 = "aab";
        String s2 = "axy";
        String s3 = "aaxaby";
        System.out.println("Is s3 an interleaving of s1 and s2? " + solution.isInterleave(s1, s2, s3));
    }
}
