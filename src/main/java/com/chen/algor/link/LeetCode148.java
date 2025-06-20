package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。、
 *
 * 这个方法很重要，及考察了链表合并，以及链表使用等等比较全面
 */
public class LeetCode148 {

    // 使用归并排序进行处理 这个方法不推荐，有内存溢出风险
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMidHead(head);
        ListNode left = head;
        ListNode right = mid.next;

        // 切断链表
        mid.next =null;

        // 分别进行排序
        left = sortList(left);
        right = sortList(right);

        // 对两个链表进行合并
       return mergeHead(left, right);
    }

    private ListNode mergeHead(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                 cur.next = left;
                 left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left != null) {
             cur.next = left;
        }
        if(right != null) {
            cur.next = right;
        }
        return dummy.next;

    }



    private ListNode getMidHead(ListNode head) {
        ListNode slow = head,fast = head;
        if(fast == null || fast.next == null){
             slow = slow.next;
             fast = fast.next.next;
        }
        return slow;
    }

    // 新的这个方法,没有内存溢出
    public ListNode sortListV2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortListV2(head);
        ListNode right = sortListV2(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        LeetCode148 solution = new LeetCode148();

        // 创建一个链表: 4 -> 2 -> 1 -> 3 -> null
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("原链表：");
        solution.printList(head);

        // 排序链表
        ListNode sortedHead = solution.sortList(head);

        System.out.println("排序后的链表：");
        solution.printList(sortedHead);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head =head.next;
        }
    }
}
