package com.chen.algor.string;

/**
 * 题目描述:
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 *
 *
 * 。
 */
public class LeetCode58 {

    /**
     * 解题思路，使用空字符串对字符进行分割，然后遍历
     * 正则匹配
     * @param s
     * @return
     */
    public static  int lengthOfLastWord(String s) {
        // 正则进行匹配
        //String[] split = s.split("\\s+");
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        String s = "   ";
        System.out.println(lengthOfLastWord(s));
    }
}
