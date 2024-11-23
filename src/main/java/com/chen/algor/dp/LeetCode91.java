package com.chen.algor.dp;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * "1" -> 'A'
 *
 * "2" -> 'B'
 *
 * ...
 *
 * "25" -> 'Y'
 *
 * "26" -> 'Z'
 *
 * 然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
 *
 * 例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1, 1, 10, 6)
 * "KJF" ，将消息分组为 (11, 10, 6)
 * 消息不能分组为  (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。
 * 注意，可能存在无法解码的字符串。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 */
public class LeetCode91 {

    // 使用动态规划
    public int numDecoding(String s) {
        // 处理特殊情况
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // 遍历数组
        for (int i = 2; i <= n; i++) {
           // 如果当前的字符串不为零，则加入到字符串中
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i - 1];
            }

            // 如果是 10-26之间的字符，那就是可以合并
            String twoStr = s.substring(i - 2, i);
            if (twoStr.compareTo("10") >= 0 && twoStr.compareTo("26") <= 0) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(new LeetCode91().numDecoding(s));

    }
}
