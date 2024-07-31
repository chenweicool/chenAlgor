package com.chen.algor.arrays;

/**
 * 题目描述
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 用例
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class LeetCode34 {

    /**
     * 巧妙，用了分治思想，真是牛逼，
     * 写两个方法，一个从左边想右找，一个从右向左找
     */
    public int[] search(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findFirstPostion(nums, target);
        result[1] = findLastPostion(nums, target);
        return result;
    }

    /**
     * 向右边找
     */
    private int findLastPostion(int[] nums, int target) {
         int left = 0;
         int right = nums.length;
         int lastPostion = -1;
        while (left <= right) {
             int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                 lastPostion = mid;
                 left =  mid +1;  // 继续在右半部分找
            } else if (nums[mid] < target) {
                  left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return lastPostion;
    }

    private int findFirstPostion(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int firstPostion = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                firstPostion = mid;
                right =  mid - 1;  // 继续在左半部分找
            } else if (nums[mid] < target) {
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return firstPostion;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] search = new LeetCode34().search(nums, 8);
        for (int i : search) {
            System.out.println(i);
        }
    }
}
