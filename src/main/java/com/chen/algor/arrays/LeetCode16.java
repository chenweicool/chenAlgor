package com.chen.algor.arrays;

import java.util.Arrays;

/**
 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 复习的次数+1
 */
public class LeetCode16 {
    public Integer threeSumClose(int[] nums, int target){
        // 利用三数之和方法来解决 先进行排序
        Arrays.sort(nums);
        // 初始化这个值，妙哉
        int closeNum = nums[0]+ nums[1] + nums[2];
        int length = nums.length;
        for (int i = 0; i <length -2 ; i++) {
             // 使用双指针来解决
            int left =  i +1;
            int right = length -1;
            while (left < right){
                int currentNums =  nums[i] + nums[left] +nums[right];
                if (Math.abs(currentNums - target) < Math.abs(closeNum - target)) {
                     closeNum = currentNums;
                }
                if (currentNums < target) {
                    left++;
                }else
                if(currentNums > target){
                    right--;
                }else{
                    return currentNums;
                }
            }
        }
        return closeNum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(new LeetCode16().threeSumClose(nums,target));
    }
}
