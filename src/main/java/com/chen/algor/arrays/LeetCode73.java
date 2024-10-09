package com.chen.algor.arrays;

import java.util.Arrays;

/**
 * 矩阵置零的操作
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class LeetCode73 {

    // 根据第一行，第一列的数据来计算，
    public static void setZeros(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
         // 判断第一行和第一列是否有零
        boolean firstColZeros = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                  firstColZeros = true;
                  break;
            }
        }

        boolean firstRowZeros = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZeros = true;
                break;
            }
        }

        // 对第一行，和第一列的数组进行标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                     matrix[i][0] = 0;
                     matrix[0][j] = 0;
                }
            }
        }

        //根据标记数组，将相应的行置为0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 根据标记数组，将相应的列置为0
        for (int j = 1; j <n ; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 判断第一行和第一列是否需要置为零
        if (firstColZeros) {
            for (int i = 0; i < m; i++) {
                 matrix[i][0] = 0;
            }
        }
        // 第一列是否需要置为零
        if (firstRowZeros) {
            for (int j = 0; j < n; j++) {
                 matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1}
        };

        setZeros(matrix);

        for (int[] subTris : matrix) {
            System.out.println(Arrays.toString(subTris));
            System.out.println();
        }
    }
}
