package com.chen.algor.string;


/**
 * 求最长的回文字符串
 * 题目描述
 * 给你一个字符串，求出这个字符串最长的回文字符串，回文字符串的含义：
 * 字符串的反序和原始相同，则该字符串为回文字符串
 * 3,2,2,3
 */
public class LeetCode5 {
    /**
     * 使用动态规划
     * 解题思路
     * 思路：
     * 创建一个二维数组 dp，其中 dp[i][j] 表示子串 s[i..j] 是否是回文子串。
     * 初始化：所有长度为 1 的子串都是回文子串，因此 dp[i][i] = true。如果两个相邻的字符相同，那么长度为 2 的子串也是回文子串。
     * 填表：对于长度大于 2 的子串，如果 s[i] == s[j] 并且 dp[i+1][j-1] 是回文子串，那么 dp[i][j] 也是回文子串。
     * 通过填表找到最长的回文子串。
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
        // 进行第一层的遍历，外层循环表示子字串，内层循环，表示字子串的起点，通过i计算终点： j = i+len-1
        /**
         *  我们不希望 j 越界（j < n），所以：
         *
         *         j = i + len - 1 < n
         *
         *         变形得：i < n - len + 1
         *
         *         简化后就是：i <= n - len
         */

        for (int L = 2; L <= len; L++) {
              // 声明左边界
            for (int i = 0; i < len; i++) {
                // 声明右边界
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
        String s = new LeetCode5().longestPalindrome(test);
        System.out.println(s);
    }
}
