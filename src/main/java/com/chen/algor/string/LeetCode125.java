package com.chen.algor.string;

import java.util.Objects;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
         // 提出非字母的字符
        StringBuilder cleanCharSb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanCharSb.append(c);
            }
        }
        // 反转下字符串是不是一样，
        String clearStr = cleanCharSb.toString().toLowerCase();
        String reverse = cleanCharSb.reverse().toString().toLowerCase();
        return Objects.equals(clearStr, reverse);

//        // 声明双指针来解决
//        int left = 0;
//        int right = clearStr.length()-1;
//        while (left <= right) {
//            if (clearStr.charAt(left) != clearStr.charAt(right)) {
//                  return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
