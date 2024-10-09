package com.chen.algor.link;

import com.chen.algor.common.ListNode;

import java.util.List;

/**
 * 删除链表中的重复元素
 *给定一个已排序的链表的头 head,
 *  删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表,
 */
public class LeetCode82 {

    /**
     *
     在 Java 中，ListNode prev = dummy; 这条语句只是创建了一个对 dummy 的引用。此时，prev 和 dummy 指向同一个对象。

     程序执行结束后，prev 和 dummy 的关系仍然存在，但它们可以在逻辑上表现出不同的状态：

     引用共享：prev 和 dummy 最开始指向同一个节点，因此任何通过 prev 的修改（如 prev.next）也会影响到 dummy 的结构。

     遍历变化：在遍历和修改链表的过程中，prev 会不断移动到下一个节点，而 dummy 的引用保持不变。因此，prev 的值在循环中改变，但 dummy 始终指向链表的开始。

     创建虚拟节点作用：
     创建虚拟节点的主要目的是简化链表操作。具体原因包括：
     简化边界条件：虚拟节点作为链表的前驱，使得处理头节点的删除变得更简单，避免特殊情况，比如当头节点本身就是重复节点时。

     统一处理逻辑：无论是删除头节点还是中间节点，逻辑都可以一致，无需为头节点的情况单独处理。

     避免空指针异常：在操作链表时，虚拟节点确保在链表为空或只有一个节点时也能正常工作，减少了需要额外检查的情况。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(0);
         dump.next =  head;
        ListNode prev = dump; // 指向当前不重复的节点
        while (head != null) {
            // 如果当前节点和下一个节点相同，就跳过所有的重复的节点
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;  // 只想重复节点下一个节点
            }else{
                prev = prev.next;  // 将虚拟指针移动
            }
            head = head.next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = new LeetCode82().deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
