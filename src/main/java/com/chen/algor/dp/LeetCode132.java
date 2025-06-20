package com.chen.algor.dp;

/**
 * 题目描述
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 * 返回符合要求的 最少分割次数 。
 */
public class LeetCode132 {

    // 解题思路： 使用动态规划来解决
    public int minCut(String s) {
        int n = s.length();
        // 声明一个数组存储具体值
        int[] dp = new int[n];

        //声明表示是不是一个回文字符串
        boolean[][] isPalindrome = new boolean[n][n];
        
        // 最坏情况，进行填充
        for (int i = 0; i <n ; i++) {
              dp[i] = i;
        }
        
        // 进行填表，判断是s,i,j是不是回文字符串
        for (int len = 1; len <= n ; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                 int j = i+len -1; // 字符串结束的位置
                if (len == 1) {
                    isPalindrome[i][j] = true;  // 单个字符串是回文
                } else if (len == 2) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1]; // 两边字符相等且中间部分是回文

                }
            }
        }
        
        // 去除分割次数最小的
        for (int i = 1; i < n; i++) {
            if (isPalindrome[0][i]) {
                 dp[i] = 0;
            }else{
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode132().minCut("aab"));
    }
}
