package com.chen.algor.dp;

/**
 * 字符串匹配问题，和第10道题一样
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class LeetCode44 {
    /**
     * 解题思路使用动态规划，
     * 1 声明dp用来存储结果 dp[i][j]来表示s的前i个字符串和p的前J个字符串是否匹配
     * 2 基本情况:  dp[0][0] = true，表示空字符串匹配空模式。对于 dp[0][j]，
     * 如果模式的第 j 个字符是 *，则 dp[0][j] 继承 dp[0][j-1] 的值。
     * 3 转移方程：
     * 如果模式字符是 *，可以选择匹配零个或多个字符，因此 dp[i][j] 取决于 dp[i-1][j]（*匹配一个字符）或 dp[i][j-1]（*匹配零个字符）。
     * 如果模式字符是 ? 或与当前字符串字符相同，继承 dp[i-1][j-1] 的值。
     * 否则，当前匹配失败，dp[i][j] = false。
     * @param s
     * @param p
     * @return
     */
    public static  boolean isMatch(String s, String p) {
          int m =  s.length();
        int n = p.length();

        // 声明dp表存储结果
        boolean dp[][] = new boolean[m+1][n+1];
        // 空串匹配空字符
        dp[0][0] = true;

        // 对dp[0][j]进行处理
        for (int j = 1; j <= n; j++) {
             if(p.charAt(j-1) == '*'){
                 dp[0][j] = dp[0][j - 1];
             }
        }

        // 进行匹配处理
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }
}
