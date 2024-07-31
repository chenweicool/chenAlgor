package com.chen.algor.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class LeetCode39 {
    /**
     * 可以使用回溯来解决这个问题
     * 1 递归方法用于构建可用于列表
     * 声明一个remain方法
     * 1  如果 remain <0  说明当前这个数组不适合，就直接跳过，如果等于0就加入当前的列表，
     * 2  循环遍历数组，因为可以重复调用，所有，每次调用从当前元素开始
     * 3  每次递归返回后，就从列表移除不满足的元素元素
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 声明结果
        List<List<Integer>> result = new ArrayList<>();
        // 递归返回该有的结果
        backTrace(result, new ArrayList<>(), candidates, target, 0);
        // 递归解决这个问题
        return result;
    }

    /*
     */
    private void backTrace(List<List<Integer>> result, ArrayList<Integer> templist, int[] candidates, int target, int start) {
        // 不满足就结束
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(templist));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 加入数组
                templist.add(candidates[i]);
                backTrace(result, templist, candidates, target - candidates[i], i);
                // 如果递归不满足，回调
                templist.remove(templist.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        List<List<Integer>> lists = new LeetCode39().combinationSum(nums, 8);
        lists.forEach(p -> {
            System.out.println(Arrays.toString(p.toArray()));
        });
    }
}
