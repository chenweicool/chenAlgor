package com.chen.algor.arrays;

import java.util.Arrays;

/**
 * 生成矩阵
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class LeetCode59 {
    // 逐个声明下
    public static int[][] generateMatrix(int n) {
        // 声明一个容器
        int[][] matrix = new int[n][n];
        int left = 0,right = n-1,top = 0,bottom = n-1;
        int num = 1;

        // 进行循环
        while (left <= right && top <= bottom) {
              // 上行
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            // 右行
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            // 下行
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            // 左行
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
            System.out.println();
        }
    }
}
