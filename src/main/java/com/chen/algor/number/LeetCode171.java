package com.chen.algor.number;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class LeetCode171 {

    /**
     * 使用进制进项转换
     */
    public int convertToDecimal(String str, int base) {
         int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = 0;
            if(c >= 'A' && c <= 'Z'){
                value = c - 'A' + 1;
            } else if (c >= 'a' && c <= 'z') {
                value = c - 'a' + 1;
            }else{
                value = c - '0';
            }
            result = result * base + value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode171().convertToDecimal("ZY",26));
    }
}
