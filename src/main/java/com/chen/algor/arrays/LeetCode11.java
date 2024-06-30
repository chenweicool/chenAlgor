package com.chen.algor.arrays;

/**
 * 题目链接:
 *
 * 题目描述。
 * 给定义一个数组，计算这个数组组成坐标所能容纳水体积的最大值
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class LeetCode11 {
    /**
     * 使用双指针来解决这个问题
     * 使用双指针来解决，确实比较简单
     * 关键在于，列出计算表达式
     *
     * 此时我们需要移动一个指针。移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，
     * 由于容纳的水量是由
     *  两个指针指向的最小值 * 指针间的距离，(木桶的最短原理)
     * 两个指针指向的数字中较小值∗指针之间的距离两个指针指向的数字中较小值 * 指针之间的距离
     * 两个指针指向的数字中较小值∗指针之间的距离
     */
    public int maxArea(int[] height) {
       int left =0;
       int right =  height.length-1;
       int maxArea = 0;
        while (right > left) {
             int width =  right-left;
            int currentArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(currentArea, maxArea);
            if (height[left] < height[right]) {
                 left += 1;
            }else {
                 right -= 1;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int i = new LeetCode11().maxArea(array);
        System.out.println(i);

        int[] array1 = {1,1};
        System.out.println(new LeetCode11().maxArea(array1));
    }
}
