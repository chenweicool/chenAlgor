package com.chen.algor.string;

import com.chen.algor.arrays.LeetCode48;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 简单说，就是将所有字母组合相同的单词，进行返回
 * ["nat","tan"] 都是这个三个单词组成
 */
public class LeetCode49 {

    /**
     * 考察了数据结构和算法之间差距
     * 第一种解决方案： 使用hashMap来解决
     * 将所有字符进行排序，每个单词异位之后排序之后，就是相同的，可以把他们加入的map中，值就是所有排序之后
     * 还是这种方法比较推荐
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串，对于每个字符进行排序
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            // 将字符串转换回来
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // 创建一个新的列表
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // 第二种方法使用计数方法，将每个数组出现的位置，进行记录，并转换为key，
    // 使用hashMap实现
    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // 对数组进行遍历
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            int[] count = new int[26];
            for (char c : charArray) {
                count[c - 'a']++;
            }
            // 将字符计数数组转换字符串作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append("#").append(num);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new LeetCode49().groupAnagramsV2(str);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
