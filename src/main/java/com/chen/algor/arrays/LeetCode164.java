package com.chen.algor.arrays;

import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 */
public class LeetCode164 {

    /**
     * 线性要求，这个要满足
     * @param nums
     */
    public int maximumGap(int[] nums) {
        // 先进行排序
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = nums[1] - nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i + 1] - nums[i]);
        }
        return max;
    }

    /**
     * 使用桶来排序
     * 🌟 桶排序的核心思想
     * 确定范围：找出数组的最小值 minVal 和最大值 maxVal，计算元素的范围。
     * 划分桶：把整个数据范围等分成多个桶（每个桶代表一个区间）。
     * 元素入桶：根据元素的值，将其放入相应的桶中。
     * 桶内排序：对每个桶内部的数据进行排序（通常使用插入排序或快排）。
     * 合并桶：按桶的顺序依次合并，得到最终的排序结果。
     */
    public int maximumGaV2(int[] nums) {
       // 找出最大值，和最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int n = nums.length;
        if (min == max) {
             return 0;
        }
        // 计算桶的大小和桶的数量
        int bucketSize = (max - min) / (n - 1);
        int bucketCount = (max - min) / bucketSize + 1;

        // 将元素如桶
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];
        Arrays.fill(bucketMax, Integer.MAX_VALUE);
        Arrays.fill(bucketMin, Integer.MIN_VALUE);
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            bucketMin[index] = Math.min(num, bucketMin[index]);
            bucketMax[index] = Math.max(num, bucketMax[index]);
            bucketUsed[index] = true;
        }
        // 计算最大间隙
        int maxGap = 0;
        int preVal = min;
        // 遍历桶
        for (int i = 0; i < bucketCount; i++) {
           if(!bucketUsed[i]) continue;
           // 这里是因为:但上一个桶的最大值 + 当前桶的最小值一定是相邻的，所以才会相减
            maxGap = Math.max(maxGap, bucketMin[i] - preVal);
            preVal = bucketMax[i];
        }
        return maxGap;

    }

    public static void main(String[] args) {
        int[] nums = {1,5,6,7,0,9};
        System.out.println(new LeetCode164().maximumGaV2(nums));
    }
}
