package com.chen.algor.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 *  。返回 s 所有可能的分割方案。
 */
public class LeetCode131 {
    /**
     * 使用回溯法，来完成，
     *逐步将字符串分割为子串，检查每个子串是否是会问字符串，如果是，继续对剩余的部分进行分割，
     * 如果分割完，将当前结果加入到序列中，
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int start, List<List<String>> result, ArrayList<String> current) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalinedrome(s, start, end)) {
                current.add(s.substring(start, end + 1));

                // 继续回溯
                backtrack(s, end + 1, result, current);

                // 回撤上一个操作
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalinedrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                 return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
