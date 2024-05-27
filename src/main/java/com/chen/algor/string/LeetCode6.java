package com.chen.algor.string;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode的第六题
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class LeetCode6 {
    // 字符串的使用

    /**
     * 解题思路，明确行索引是 s1,s2,s3,sn到达某一个点时，就会以sn,s3,s2,s1,出现
     * 声明每个行集合
     * 声明一个flag来控制z的反转
     * @param s
     * @param numberRows
     * @return
     */
    public String convert(String s, int numberRows) {
        // 确定边界条件，
        if (numberRows < 2) {
            return s;
        }
        // 初始化每行存储的数据字符
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numberRows; i++) {
            rows.add(new StringBuilder());
        }
        // 遍历字符串
        // 声明行数,以及取反标志
        int i = 0,flag = -1;
        for (char c : s.toCharArray()) {
              // 写入每行的数据
            rows.get(i).append(c);
            // 边界条件 什么时候z子进行转向的设置
            if(i == 0 || i == numberRows-1) flag = -flag;
            i += flag;
        }
        // 遍历字符串
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = new LeetCode6().convert(s, 3);
        System.out.println(convert);
    }
}
