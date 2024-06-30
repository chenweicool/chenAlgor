package com.chen.algor.string;

/**
 * 题目描述
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class LeetCode28 {

    public int strStr(String hayStack, String needle) {
          // 满足两个条件，一个是后面字符串，要在前面包含
        int i = hayStack.indexOf(needle);
        return i;
    }



    public static void main(String[] args) {
        String hatack = "abeababeabf";
        String needle = "abeabf";
        System.out.println(new LeetCode28().kmpSearch(hatack, needle));
    }

    /**
     * 使用kmp来解决这个问题
     */
    public int kmpSearch(String text, String pattern) {
        if (pattern.isEmpty()) {
             return 0;
        }
        // 先构造字符串的前缀,就是确定字符串重复出现的下标
        int[] table = builderPattern(pattern);

        int j = 0;
        // 这里要从0开始，因为是保证两个字符串匹配起始位置相同
        for (int i = 0; i <text.length() ; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                  j = table[j-1];
            }
            // 如果相等，指针右移
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            // 如果j长度等于匹配字符串长度，就是说明已经匹配上了，返回指定长度
            if (j == pattern.length()) {
                 return i-j+1;
            }
        }
        return -1;  // 没有匹配上
    }

    private int[] builderPattern(String pattern) {
        int[] table = new int[pattern.length()];

        int j = 0;
        // 比较下一个字符串和当下字符串一个大小
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                 j++;
            }
            //赋值重复元素
            table[i] = j;
        }
        return table;
    }
}
