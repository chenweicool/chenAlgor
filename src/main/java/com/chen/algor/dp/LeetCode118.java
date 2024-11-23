package com.chen.algor.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // 遍历每一行
        for (int i = 0; i < numRows; i++) {
            // 第一个元素是一1
            List<Integer> result = new ArrayList<>();
            result.add(1);

            // 中间元素由上一行进行计算
            if (i > 0) {
                List<Integer> preRow = triangle.get(i - 1);
                for (int j = 1; j < i; j++) {
                    result.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            if (i > 0) {
                result.add(1);
            }
            triangle.add(result);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode118().generate(5));
    }
}
