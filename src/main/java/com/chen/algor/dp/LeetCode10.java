package com.chen.algor.dp;

/**
 * 为什么这里要使用n-2,
 * 对于动态规划还是不是很熟悉
 * 正则表达式
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 * 题目链接地址:
 * https://leetcode.cn/problems/regular-expression-matching/description/
 */
public class LeetCode10 {

    /**
     *解题思路：
     * 使用动态规划，这个题目的是看s是否可以匹配到p
     * 可以定义一个二维表，dp[i][j] 表示，字符s前i个字符是否能被字符p的前进行匹配
     * 转移方程
     * 如果p[j-1] = s[i-1] 或者p[j-1] = . 那么dp[i][j] = dp[i-1][j-1]
     * 如果 p[j-1] == '*'，我们有两种情况：
     * p[j-2] 可以匹配 0 次，即忽略 p[j-2] 和 *，因此 dp[i][j] = dp[i][j-2]。
     * p[j-2] 至少匹配 1 次，那么我们检查 dp[i-1][j]，且要求 p[j-2] 必须与 s[i-1] 匹配。
     */
    public static boolean isMatch(String s, String p) {
        // 声明一个数组，并且数组
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // 对*进行处理
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 进行匹配
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 这里有些不太懂
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));

    }
}
