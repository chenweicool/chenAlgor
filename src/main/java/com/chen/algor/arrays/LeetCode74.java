package com.chen.algor.arrays;

/**
 * 搜索矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
 */
public class LeetCode74 {

    /**
     *怎么把一维数组映射到二维数组上
     */
    public static  boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
             return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        // 使用二分法进行查找处理
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) {
                 return true;
            }else
            if (midValue < target) {
                 left = mid +1;
            } else  {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] martix = {{1, 3, 5, 7}, {10, 11, 16, 20}};
        System.out.println(searchMatrix(martix,10));
    }
}
