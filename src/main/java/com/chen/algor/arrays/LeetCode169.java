package com.chen.algor.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) +1;
            if(count > (n/2)){
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }

    //使用摩尔投票法来解决这个问题，使用了计数抵消策略
    public int majorityElementV2(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // 选择新的候选众数
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate; // 众数一定存在，无需额外验证
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode169().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new LeetCode169().majorityElementV2(new int[]{2,2,1,1,1,2,2}));
    }
}
