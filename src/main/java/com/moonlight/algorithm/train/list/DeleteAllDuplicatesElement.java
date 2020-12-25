package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author Moonlight
 * @date 2020/12/25 17:12
 */
public class DeleteAllDuplicatesElement {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next.next = new ListNode(5);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 头部需要删除  头部不需要删除  两种情况
        if (head.val == head.next.val) {
            // 找到第一个不需要删除的结点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

}
