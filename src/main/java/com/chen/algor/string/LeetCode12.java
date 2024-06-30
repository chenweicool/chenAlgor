package com.chen.algor.string;

/**
 * 题目描述
 * 12. 整数转罗马数字
 * 直白点，就是将阿拉伯数字转换为罗马数字
 * 罗马数字和数字之间映射关系
 * 七个不同的符号代表罗马数字，其值如下：
 *
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 *
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。
 * 仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 */
public class LeetCode12 {
    /**
     * 使用映射表，
     * 也就是将罗马数字和本地数字进行映射处理。
     * 然后依据规则进行遍历
     *
     * 这道题应用了什么思想，穷举法的思想
     * @param num
     * @return
     */
    public String intToRaman(int num) {
        // 分别获取每一位数字
        int[] values =  {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symols = {"M","CM", "D","CD", "C","XC", "L", "XL","X","IX", "V","IV", "I"};
        // 遍历映射表
        StringBuilder raman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                   raman.append(symols[i]);
                num -= values[i];
            }
        }
        return raman.toString();
    }

    public static void main(String[] args) {

        System.out.println(new LeetCode12().intToRaman(58));
        System.out.println(new LeetCode12().intToRaman(1994));
        System.out.println(new LeetCode12().intToRaman(3749));
    }
}
