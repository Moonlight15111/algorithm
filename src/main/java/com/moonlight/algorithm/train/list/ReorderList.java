package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/reorder-list/
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author Moonlight
 * @date 2020/12/28 12:30
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reorderList(head);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 1. 找中点 2. 切割成head、左、右三个链表  3. 右链表逆序  4.合并
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // 找到除head外的中点
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 源链表长度为偶数则除head外的链表的中点为原中点的next
        if ((len & 1) == 0) {
            slow = slow.next;
        }

        ListNode leftHead = head.next;
        head.next = null;

        ListNode rightHead = slow.next;
        slow.next = null;
        // 反转右边的链表，合并到左边
        rightHead = reverse(rightHead);

        ListNode tmpHead = new ListNode(Integer.MIN_VALUE);
        cur = tmpHead;
        while (rightHead != null && leftHead != null) {
            ListNode rightNext = rightHead.next;
            cur.next = rightHead;
            cur.next.next = leftHead;
            rightHead = rightNext;
            leftHead = leftHead.next;
            cur = cur.next.next;
        }
        head.next = tmpHead.next;

        return head;
    }

    private static ListNode reverse(ListNode rightHead) {
        ListNode next, prev = null;

        while (rightHead != null) {
            next = rightHead.next;
            rightHead.next = prev;
            prev = rightHead;
            rightHead = next;
        }

        return prev;
    }

}
