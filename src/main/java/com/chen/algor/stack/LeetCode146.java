package com.chen.algor.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，
 * 则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 具体实现思路：
 * 1 使用hashMap和双端链表来实现
 * 使用HashMap存储节点对应的映射值
 * 使用节点存储访问最近和最远节点
 */
public class LeetCode146 {

    private Map<Integer, Node> map ;
    private Node head;
    private Node tail;
    private int capacity;
    public LeetCode146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next =tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 删除node
            removeNode(node);
            // 将值加入到最前面
            addFirstHead(node);
            return node.value;
        }
        return -1;
    }

    private void addFirstHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addFirstHead(node);
        }else {
            if (map.size() >= capacity) {
                // 删除尾部节点
                Node node = tail.pre;
                 removeNode(node);
                map.remove(node.key);
            }
            Node newNode = new Node(key, value);
            addFirstHead(newNode);
            map.put(key, newNode);
        }
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LeetCode146 lRUCache  = new LeetCode146(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3);// 该操作会使得关键字 2 作
        lRUCache.get(3);
        Node head1 = lRUCache.head;
        while (head1 != null) {
            System.out.println(head1.value);
            head1 = head1.next;
        }
    }
}
