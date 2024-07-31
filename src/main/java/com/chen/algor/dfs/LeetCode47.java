package com.chen.algor.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 算法题解的47道题
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 要求: 返回所有不重复的全排列
 */
public class LeetCode47 {

    public  List<List<Integer>> preUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        // 对数组进行一个排序
        Arrays.sort(nums);
        // 设置一个哨兵
        boolean[] used = new boolean[nums.length];
        // 使用回溯法进行处理
        backtrace(result, new ArrayList<Integer>(), nums, used);
        return result;
    }

    private void backtrace(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
          // 回溯的边界条件
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length; i++) {
                // 如果数字被使用过，就跳过
                if(used[i]) continue;
                  // 跳过重复元素
                if(i > 0 && nums[i] == nums[i-1] && ! used[i-1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrace(result, tempList, nums, used);

                // 回溯结束，取消标记
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        new LeetCode47().preUnique(nums).forEach(
                p ->{
                    System.out.println(Arrays.toString(p.toArray()));
                }
        );
    }

}
