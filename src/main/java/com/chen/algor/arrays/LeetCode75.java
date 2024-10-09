package com.chen.algor.arrays;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class LeetCode75 {

    /**
     * 使用荷兰过期来解决这个问题，主要使用三指针，分别标记红色，蓝色和白色，
     * 这样遍历一遍数组就可以了
     * @param nums
     */
    public  void sortColors(int[] nums) {
        // 声明三个颜色，使用三指针来解决这个问题
       int red = 0,white = 0,blue =  nums.length-1;

       // 遍历数组移动指针
        while (white <= blue) {
            if (nums[white] == 0) {
                // 交换白色和指针和红色指针的值
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] == 1) {
                // 如果是白色就不动这个值
                 white++;
            }else{
                // 交换蓝色和白色的值
                swap(nums, white, blue);
                blue--;
            }
        }
    }

    private void swap(int[] nums, int red, int white) {
        int temp = nums[white];
        nums[white] = nums[red];
        nums[red] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 0};
        new LeetCode75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
