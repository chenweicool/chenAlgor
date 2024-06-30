package com.chen.algor.string;

import java.util.HashMap;
import java.util.Map;

/**
 *数据处理
 * 整数转换为罗马数字
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class LeetCode13 {
    /**
     * 核心思想，是判断上一位和下一位的关系
     * 遍历字符串，然后比较两边的大小
     * 这个是从左向右遍历，比较的是自己下一位的值，最后一位还是要加上，
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        // 先遍历字符串
        int sum = 0;
        int preNum = getCharValue(s.charAt(0));
        for (int i = 1; i <s.length() ; i++) {
               // 得到下一个字符
            int num = getCharValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    //chatGpt的解答
    public int romanToInt2(String s) {
         // 声明一个字典
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        // 从右向左进行遍历，如果当前值小于其右侧的值，则减去否则相加
        int total = 0;
        int preValue = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            char c = s.charAt(i);
            Integer currentValue = romanValues.get(c);
            if (currentValue < preValue) {
                total -= currentValue;
            }else{
                total += currentValue;
            }
            preValue = currentValue;
        }
        return total;
    }

    private int getCharValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(new LeetCode13().romanToInt(s));
        System.out.println("romdan" + new LeetCode13().romanToInt2(s));
    }
}
