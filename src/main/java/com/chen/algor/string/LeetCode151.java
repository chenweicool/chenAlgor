package com.chen.algor.string;

/**
 * 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class LeetCode151 {

    // 解题思路，利用空格把字符串进行分割，然后进行反转组装输出
    public String reverseWords(String s) {
         // 去除前后空格，并替换多余空格，
        s = s.trim().replaceAll("\\s+", " ");

        // 对字符串进行分割
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                 sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode151().reverseWords("the sky is blue"));
    }
}
