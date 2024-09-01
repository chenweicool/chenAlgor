package com.chen.algor.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 旋转矩阵
 * 你的思路是什么
 * 分治的思想 分着来看，这个题目，从从左到右，然后从上到下 ，然后从右向左，然后从下到上
 * 题目链接：
 * https://leetcode.cn/problems/spiral-matrix/description/
 */
public class LeetCode54 {
    // 从左至右，不停进行遍历
    public static  List<Integer> spirOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        // 声明四个边界
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0,right = n-1,top = 0,bottom = m-1;

        // 对数组进行遍历
        while (left <= right && top <= bottom) {
             // 从左向右遍历上边
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 从上到下遍历右边
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 从右到左遍历下边
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // todo 这里不是很懂
            if (left <= right) {
                // 从下到上遍历左边
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        List<Integer> result = spirOrder(matrix);
        System.out.println(result); // 输出：[1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
