package com.chen.algor.string;


/**
 * 求最长的回文字符串
 * 题目描述
 * 给你一个字符串，求出这个字符串最长的回文字符串，回文字符串的含义：
 * 字符串的反序和原始相同，则该字符串为回文字符串
 */
public class LeetCode4 {
    /**
     * 使用动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        if(len < 2){
            return s;
        }
        // 进行第一层的遍历
        for (int L = 2; L <= len; L++) {
              // 声明左边界
            for (int i = 0; i < len; i++) {
                // 声明左边界
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                // 进行具体判断
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                }else{
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                     maxLen = j-i+1;
                     begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String test = "abbac";
        String s = new LeetCode4().longestPalindrome(test);
        System.out.println(s);
    }
}
