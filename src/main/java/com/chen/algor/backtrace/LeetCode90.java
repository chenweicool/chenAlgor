package com.chen.algor.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class LeetCode90 {

    // 使用回溯的方法来解决这个问题
    public  List<List<Integer>> subSetsWithUp(int[] nums){
         // 先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // 回溯法进行调用
        backtrack(result,new ArrayList<>(),nums,0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> subSet, int[] nums, int start) {
        // 这里一定是new 一个对象
        result.add(new ArrayList<>(subSet));
        // 遍历数组
        for (int i = start; i <nums.length ; i++) {
           // 避免重复元素
           if(i > start && nums[i] == nums[i-1]) continue;

            subSet.add(nums[i]);
            backtrack(result, subSet, nums, i + 1);

            // 移除元素
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = new LeetCode90().subSetsWithUp(nums);
        System.out.println(lists);
    }
}
