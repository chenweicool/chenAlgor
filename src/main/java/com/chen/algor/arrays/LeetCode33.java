package com.chen.algor.arrays;

/**
 * 题目描述
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 要求对复杂度有了要求了
 */
public class LeetCode33 {

    // 这个题使用二分法来解决比较好

    /**
     *解题思路： 声明两个指针，left 和right
     * 2 遍历数组，使用二分法从左边和右边去找
     * 3  如果等于目标值就返回，
     * 4 如果不等于，判断那边有序，更新mid的值，继续找
     */
    public int search(int[] nums, int target) {
         int left = 0;
        int right = nums.length - 1;

        // 遍历数组进行查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果相等直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 左半部分是有序的
            if (nums[left] <= nums[mid]) {
                 // 更新左右游标
                if (target >= nums[left] && nums[mid] > target) {
                      right = mid-1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (target <= nums[right] && target > nums[mid]) {
                      left = mid +1;
                }else{
                    right = mid-1;
                }
            }
        }
        // 没有找到就返回-1；
        return -1;
    }

  // 单侧
  public static void main(String[] args) {
      int[] nums = {4, 5, 6, 7, 0, 1, 2};
      System.out.println(new LeetCode33().search(nums, 0));
  }
}
