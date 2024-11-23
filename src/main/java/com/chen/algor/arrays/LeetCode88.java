package com.chen.algor.arrays;

/**
 * 题目描述
 * 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 */
public class LeetCode88 {
    public void merge(int[] num1, int m, int[] num2, int n) {
        // 使用三指针来解决
        int p1 =  m-1;
        int p2 = n-1;
        int p = m+n-1;

        // 有后向前进行遍历
        while(p1 >= 0 && p2 >=0){
             if(num1[p1] > num2[p2]){
                  num1[p] = num1[p1];
                  p1--;
             }else{
                  num1[p] = num2[p2];
                  p2--;
             }
             p--;
        }

        // 如果遍历结束，num2还剩余元素，那就复制到num1中
        while(p2 >= 0){
             num1[p] = num2[p2];
             p2--;
             p--;
        }
    }

    public static void main(String[] args) {
        LeetCode88 solution = new LeetCode88();

        int[] nums1 = {1, 2, 3, 0, 0, 0};  // nums1 大小为 m + n
        int m = 3;  // nums1 中的有效元素个数
        int[] nums2 = {2, 5, 6};  // nums2 中的有效元素
        int n = 3;  // nums2 中的元素个数

        solution.merge(nums1, m, nums2, n);

        // 输出合并后的结果
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
