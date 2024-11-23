package com.chen.algor.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class LeetCode119 {
    // 和上一个题类似
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triganle = new ArrayList<>();

        // 构造杨辉三角
        for(int i = 0; i < rowIndex+1; i++){
            List<Integer> result = new ArrayList<>();

            result.add(1) ;

            // 完成中间的值
            if(i > 0){
                List<Integer> preRows = triganle.get(i-1);

                // 构造中间的数
                for(int j = 1; j < i; j++){
                    result.add(preRows.get(j-1) + preRows.get(j));
                }
            }

            // 最后一个值
            if(i > 0){
                result.add(1);
            }
            triganle.add(result);
        }

        return triganle.get(triganle.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode119().getRow(3));
    }
}
