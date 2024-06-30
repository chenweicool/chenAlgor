package com.chen.algor.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和]
 * 题目链接
 * 你返回所有和为 0 且不重复的三元组。
 * https://leetcode.cn/problems/3sum/
 */
public class LeetCode15 {

    /**
     * 使用循环和双指针的方法
     * 循环加遍历
     * 找到第一个指针，然后循环
     * @param nums
     * @return
     */
    public List<List<Integer>>  sumThree(int[] nums){
        // 先对数组进行排序，检查可重复的数字
        Arrays.sort(nums);
        int n =  nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组进行第一层遍历
        for (int i = 0; i < n -2; i++) {
             // 这里跳过的是已经处理过的元素
            if (i > 0 && nums[i] == nums[i - 1])  continue;

            // 从左右进行
            int left = i + 1;
            int right = n-1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if(total == 0){
                    // 满足条件
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复的元素
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right -1])
                        right--;
                    // 向内移动
                    left++;
                    right--;
                } else if (total < 0) {
                     left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new LeetCode15().sumThree(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
