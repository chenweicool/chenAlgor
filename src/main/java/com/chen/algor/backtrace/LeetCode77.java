package com.chen.algor.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        // 使用回溯
        backtrack(result, combination, n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int k, int start) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // 遍历加入指定组合
        for (int i = start; i <=n; i++) {
            combination.add(i);
            backtrack(result, combination, n, k, i + 1);
            // 移除这个组合
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new LeetCode77().combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.println(Arrays.toString(integers.toArray()));
            System.out.println();
        }
    }
}
