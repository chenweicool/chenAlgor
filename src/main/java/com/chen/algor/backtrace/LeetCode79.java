package com.chen.algor.backtrace;

/**
 * 单词搜索
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        // 遍历整个board，寻找单词的首字母
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从找到的第一个字母开始，进行深度优先搜索
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;  // 如果遍历完整个board都找不到返回false
    }

    // dfs 深度优先搜索
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // 边界条件判断：如果索引越界或者当前字母不匹配，返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }

        // 如果单词的所有字母都匹配，则返回true
        if (k == word.length() - 1) {
            return true;
        }

        // 临时保存当前单元格的值，并将其标记为已经访问
        char temp = board[i][j];
        board[i][j] = '*';  // 标记为已访问

        // 四个方向进行递归搜索（上、下、左、右）
        boolean result = dfs(board, word, i + 1, j, k + 1) ||  // 下
                dfs(board, word, i - 1, j, k + 1) ||  // 上
                dfs(board, word, i, j + 1, k + 1) ||  // 右
                dfs(board, word, i, j - 1, k + 1);    // 左

        // 恢复当前单元格的值
        board[i][j] = temp;

        return result;  // 如果匹配到单词则返回true，否则继续寻找
    }

    public static void main(String[] args) {
        LeetCode79 solution = new LeetCode79();
        // 这是字母索引
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";

        System.out.println(solution.exist(board, word));  // 输出: true
    }
}
