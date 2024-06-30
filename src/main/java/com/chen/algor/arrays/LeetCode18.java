package com.chen.algor.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *题目描述
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class LeetCode18 {
    // 在三数之和基础上，来解决这个问题，,具体使用排序和双指针来解决这个问题
    // 1  先对数组进行排序
    // 2  固定前两个数字，然后，使用双指针寻找后两位目标数字
    public List<List<Integer>> matchTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
         // 声明边界条件
        if (nums == null || nums.length <= 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
               // 跳过重复元素
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                 if(j > i+1 && nums[j] == nums[j-1]) continue;

                 // 使用双指针
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    // 防止整型数组越界
                     long sum = (long)nums[i]+ nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 移动左指针，避免重复
                       while (left < right && nums[left] == nums[left+1]) left++;
                        // 移动右指针，避免重复
                       while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                         left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        List<List<Integer>> lists = new LeetCode18().matchTarget(nums, 0);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
