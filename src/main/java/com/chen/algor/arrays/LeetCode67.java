package com.chen.algor.arrays;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * leetCode的第67道题
 */
public class LeetCode67 {

    /**
     * 从右想左进行加和，返回结果
     *
     * @return
     */
    public static  String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();
         // 声明两个变量
        int i = a.length()-1;
        int j = b.length()-1;
        
         int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                 sum += a.charAt(i)- '0';
                 i--;
            }
            if(j >= 0){
                 sum +=b.charAt(j) -'0';
                 j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        // 因为是从右向左加的，所以需要反转下字符串
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1101";

        System.out.println(addBinary(a, b));
    }
}
