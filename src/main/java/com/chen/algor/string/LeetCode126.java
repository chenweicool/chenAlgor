package com.chen.algor.string;

import java.util.*;

/**
 *单词接龙，
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列
 * 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 *
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。
 * 请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。
 * 每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 */
public class LeetCode126 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
         // 将单词初始化
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        int wordLength = beginWord.length();
        // 构建通配符列表
        Map<String, List<String>> allComputeMap = new HashMap<>();
        for (String word : wordSet) {
            for (int i = 0; i < wordLength; i++) {
                String wild = word.substring(0, i) + "*" + word.substring(i + 1);
                allComputeMap.computeIfAbsent(wild, k -> new ArrayList<>()).add(word);
            }
        }

        // 声明队列，进行bfs遍历，
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 标识下访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        // 进行层序遍历
        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String currentWord = poll.getKey();
            int level = poll.getValue();
            // 遍历当前所有单词的通配符模式
            for (int i = 0; i < wordLength; i++) {
                String wildWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);
                List<String> neighbors = allComputeMap.getOrDefault(wildWord, new ArrayList<>());
                for (String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) {
                         return  level+1;
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(new Pair<>(neighbor, level + 1));
                    }
               }
                allComputeMap.put(wildWord, new ArrayList<>());
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode126 wl = new LeetCode126();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
}

 class  Pair<K,V>{
    private final  K key;
    private final V value;

     public Pair(K key, V value) {
         this.key = key;
         this.value = value;
     }

     public K getKey() {
         return key;
     }

     public V getValue() {
         return value;
     }
 }
