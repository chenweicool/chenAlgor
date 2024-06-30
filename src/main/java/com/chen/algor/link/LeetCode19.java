package com.chen.algor.link;

import com.chen.algor.common.ListNode;


/**
 * 19道题，删除链表的倒数的指定节点，
 *
 */
public class LeetCode19 {
    /**
     * 这个题的关键是找到那个要删除节点，
     * 然后进行删除复
     * @param n
     * @return
     */
    public ListNode removeNode(ListNode head, int n) {
          // 声明一个亚节点
        ListNode dump = new ListNode(0,head);
        // 得到链表的长度
        int length = getNodeLength(head);
        ListNode curr = dump;
        // 遍历找到这个要删除的链表节点
        for (int i = 1; i <length - n +1 ; i++) {
              curr = curr.next;
        }
        // 删除指定链表,这里不是很懂，需要打个断点看下了
        curr.next = curr.next.next;
        return dump.next;
    }

    private int getNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 使用双指针的解法
     * 核心就是
     * 由于我们需要找到倒数第 n个节点，因此我们可以使用两个指针 first 和 second 同时对链表进行遍历，
     * 并且 first比 second超前 n个节点。
     * 当first 遍历到链表的末尾时，second 就恰好处于倒数第 n 个节点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeTwoTh(ListNode head, int n) {
         // 声明一个头节点
        ListNode dump = new ListNode(0, head);
        // 将头节点分别赋值到快慢指针
        ListNode first = dump;
        ListNode seconde = dump;
        for (int i = 0; i <= n ; i++) {
            first = first.next;
        }
        // 以first为准，对seconde进行异步,此时的seconde就是要删除节点
        while (first != null) {
            first = first.next;
            seconde = seconde.next;
        }
        seconde.next = seconde.next.next;
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode seconde = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        first.next = seconde;
        seconde.next = three;
        three.next = four;
        four.next = five;
        ListNode listNode = new LeetCode19().removeTwoTh(first, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
