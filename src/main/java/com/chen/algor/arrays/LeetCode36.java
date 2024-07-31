package com.chen.algor.arrays;

import com.chen.algor.backtrace.LeetCode40;

/**
 * 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class LeetCode36 {

    /**
     * 1 解题步骤，先判断解题条件是什么
     * 满足三个条件：声明三个数组，
     * 2 然后遍历判断，这三个条件
     */
    public boolean isValidSudoku(char[][] board) {
        // 声明三个数组行和列
        boolean[][] row = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        // 然后遍历行，遍历列
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                // 将字符转换为数字 0-8，这是因为初始化之后索引都是0到1了
                int num = board[r][c] - '1';
                // 计算当前数独的索引值,计算目前是处于那个九宫格内
                int boxIndex = (r / 3) * 3 + c / 3;

                // 检查是否已经有对应的行，只要有一个存在，就异常
                if (row[r][num] || cols[c][num] || box[boxIndex][num]) {
                    return false;
                }
                row[r][num] = true;
                cols[c][num] = true;
                box[boxIndex][num] = true;
            }
        }
        //所有检查生效，数独有效
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                 {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = new LeetCode36().isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
