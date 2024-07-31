package com.chen.algor.backtrace;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class LeetCode40 {

    /**
     * 解法和39道题很是类似
     * 唯一区别是: 这个题不需要重复元素，也就是递归不能从当前位置开始
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 为了处理重复的数字，首先对数字进行排序
        Arrays.sort(candidates);
        backtrace(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrace(List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
             return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        }else{
            for (int i = start; i < candidates.length; i++) {
                // 处理重复的数字,处理的过的数字，就不再处理
                if(i > start && candidates[i] == candidates[i-1]){
                    continue;
                }
                tempList.add(candidates[i]);
                backtrace(result, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        for (List<Integer> integers : new LeetCode40().combinationSum2(nums, 8)) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }
}
