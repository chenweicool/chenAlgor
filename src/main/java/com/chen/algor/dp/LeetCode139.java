package com.chen.algor.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态规划
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class LeetCode139 {
    /**
     * 解题思路
     * 1 声明一个dp数组，dp[i]表示，s[0,i-1]是可以组成字典中的元素的
     * 2  遍历j ,如果dp[j]和s[j,i-1]是true的话，那么dp[i]就是true,返回所有元素
     * 3 dp[length]就是结果，
     */
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> hashSet = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 优化版，减少内才能循环次数，提前跳出循环,优化，通过减少循环次数
    public boolean wordBreak2(String s, List<String> wordDict){
         boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> hashSet = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String string : wordDict) {
              maxLength = Math.max(maxLength, string.length());
        }

        // 通过动态规划来求解，
        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - maxLength); j < i; j++) {
                 if(dp[j] && hashSet.contains(s.substring(j, i))) {
                     dp[i] = true;
                     break;
                 }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode139().wordBreak2("leetcode", Arrays.asList("leet", "code")));
    }
}
