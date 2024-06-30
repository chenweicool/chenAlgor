package com.chen.algor.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除指定排序的数组中重复元素，返回新的数组的大小
 * 要求: 原地，返回指定长度
 * 要求，原地使用数组，应该是不需要使用多余的空间
 * 剩余其他元素不重要
 * 解题思路:
 *  双指针
 *
 */
public class LeetCode26 {

    // 没有满足原地删除的要求
    public int removeDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                  continue;
            }
            set.add(nums[i]);
        }
        return set.size();
    }

    // 使用双指针真的很巧妙
    public int removeDuplicateV2(int[] nums){
        // 边界条件
        if (nums == null || nums.length == 0) {
             return 0;
        }
        // 声明慢指针，用来跟踪不重复的数组
        int slow = 0;
        // 用快指针指向下一个元素，如果不相等，就是新的元素，慢指针移动向右移动一位
        for (int fast = 1; fast < nums.length ; fast++) {
            if (nums[fast] != nums[slow]) {
                 slow ++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2};
       // System.out.println(new LeetCode26().removeDuplicate(nums));

        System.out.println(new LeetCode26().removeDuplicateV2(nums));

    }
}
