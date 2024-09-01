package com.chen.algor.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后的问题，
 * 题目描述
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class LeetCode51 {

    // 适用回溯算法来解决这个问题，
    public List<List<String>> solveNQueens(int n) {
        // 声明一个对象数组，存放结果
        List<List<String>> results = new ArrayList<>();
        // 初始化一个数组，也就是棋盘的位置
        int[] queens = new int[n];
        //进行回溯递归调用
        solveQueensBack(results, 0, n, queens);
        return results;
    }

    private void solveQueensBack(List<List<String>> results, int row, int n, int[] queens) {
         // 递归边界条件，如果行等于n的情况下，进行递归赋值
        if (row == n) {
            results.add(generateRestult(queens, n));
            return;
        }
        // 遍历queens,判断是否需要进行递归
        for (int col = 0; col < n; col++) {
            if (isValied(queens, row, col)) {
                queens[row] = col;
                solveQueensBack(results, row + 1, n, queens);
            }
        }
    }

    private boolean isValied(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            // 检查列冲突，对角线冲突，
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                 return false;
            }
        }
        return true;
    }

    private List<String> generateRestult(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(row, '.');
            }
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        LeetCode51 solution = new LeetCode51();
        int n = 4;
        List<List<String>> results = solution.solveNQueens(n);
        for (List<String> solutionBoard : results) {
            for (String row : solutionBoard) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
