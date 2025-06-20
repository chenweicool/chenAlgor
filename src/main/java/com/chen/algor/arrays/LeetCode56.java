package com.chen.algor.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *数组进行排序
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 *
 * 题目链接：
 * https://leetcode.cn/problems/merge-intervals/description/
 */
public class LeetCode56 {

    /**
     * 解题思路
     * 排序：我们首先对区间按照起点进行排序，使用 Arrays.sort 方法。
     * 合并：遍历排序后的区间，如果当前区间的终点与下一个区间的起点重叠或相连，则将它们合并。否则，将当前区间添加到结果列表中，
     * 并更新当前区间为下一个区间。
     * 返回结果：最后，我们将结果列表转换为二维数组并返回。
     */
    public static int[][] merge(int[][] intervals) {
        // 设置边界条件
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 对于元素中首字母进行排序，
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int[] currentInterval = intervals[0];

        // 对数组进行遍历和合并
        for (int i = 1; i < intervals.length; i++) {
               // 比较大小
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }else{
                // 没有重叠，进行添加结果集中
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        // 添加最后一个区间
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        // 指定区间
        int[][] intervals = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};

        int[][] mergedIntervals = merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
