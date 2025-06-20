package com.chen.algor.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi]
 * 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end]
 * 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 */
public class LeetCode57 {


    /**
     * 以新数组为界限，分成三段进行处理
     * 1，先添加所有小于目标数组数字
     * 2， 合并所有与interval相同区间
     * 3，将新的区间添加到目标区间之后
     */
    public static  int[][] insertInterVal(int[][] intervals, int[] newIntervals) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // 添加所有小于目标组数字的
        while (i < n && intervals[i][1] < newIntervals[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 合并重复区间
        while (i < n && intervals[i][0] <= newIntervals[1]) {
            newIntervals[0] = Math.min(newIntervals[0], intervals[i][0]);
            newIntervals[1] = Math.max(newIntervals[1], intervals[i][1]);
            i++;
        }
        // 将合并后的区间加入结果
        result.add(newIntervals);
        // 将最后元素加入
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

       int[][] result = insertInterVal(intervals, newInterval);

        System.out.println("插入后的区间列表:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
