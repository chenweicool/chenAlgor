package com.chen.algor.arrays;

/**
 * 缺失的整数第一位数，
 * leetCode41道题，使用数组来解决
 */
public class LeetCode41 {

    /**
     * 解题思路
     * 1 只关心正整数，非整数不用关心
     * 2 将所有数字放到正确的位置，这一步很重要，比如1 放到0的位置，2 放到1的位置，以此类推，这个使用while循环,这一步很重要，比较重要
     * 3 遍历已经放置好的数组，然后进行遍历，当num[i] != i+1时，那么第i+1就是缺失的索引，返回，这个就是下标，否则就是n+1返回。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
         int n = nums.length;

         // 遍历数组，将数组位置放置正确的位置
        for (int i = 0; i < n; i++) {
             // 数组进行交换位置，使用while进行交换
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                // 交换nums[i]和nums[nums[i]-1]
                 int temp = nums[nums[i]-1];
                  nums[nums[i]- 1] = nums[i];
                  nums[i] = temp;
            }
        }
        // 遍历数组，找到第一个不满足条件下标进行返回
        for (int i = 0; i <n ; i++) {
            if (nums[i] != i + 1) {
                 return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(new LeetCode41().firstMissingPositive(nums));
    }
}
