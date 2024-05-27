package com.chen.algor.string;

import java.util.HashSet;
import java.util.Set;

/**
 * leetCode的第三道题
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LeetCode3 {
    /**
     * 使用滑动窗口来解决这个问题
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int rk = -1,ans = 0;
        int n = s.length();

        // 进行第一次遍历,也就是左指针移动
        for (int i = 0; i < n; i++) {
            // i就是左窗口，rk就是右窗口
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            // 右指针移动
            while( rk+1 < n && !occ.contains(s.charAt(rk+1))){
                 occ.add(s.charAt(rk+1));
                 ++rk;
           }
            // 取出最大值
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 测试这个主类
     * @param args
     */
    public static void main(String[] args) {
        String s = "abbbcaa";
        System.out.println(new LeetCode3().lengthOfLongestSubstring(s));
    }
}
