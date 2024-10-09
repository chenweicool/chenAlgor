package com.chen.algor.backtrace;

import javax.xml.soap.SAAJMetaFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 */
public class LeetCode78 {

    public List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> subSet = new ArrayList<>();

        backtrack(0, nums, result, subSet);
        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result, List<Integer> subSet) {
        result.add(new ArrayList<>(subSet));

        // 进行遍历回说
        for (int i = start; i < nums.length; i++) {
            subSet.add(nums[i]);
            backtrack(i + 1, nums, result, subSet);

            // 移除最上面的顶元素
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new LeetCode78().subSets(nums);
        System.out.println(lists);
    }
}
