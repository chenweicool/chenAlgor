package com.chen.algor.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态规划
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict){
        // 字典来存储这个值
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                      dp[i] = true;
                      break;
                }
            }
        }
        return dp[n];
    }
}