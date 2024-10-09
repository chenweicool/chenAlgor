package com.chen.algor.arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 也就是删除出现了3次以上的的元素
 *
 */
public class LeetCode80 {

    /**
     * 使用双指针解决这个问题
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        // 初始化慢指针
        int slow = 2;

        for (int fast = 2; fast < nums.length; fast++) {
            // 收集小于3次出现的次数
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 3, 2};
        System.out.println(new LeetCode80().removeDuplicates(nums));
    }
}
