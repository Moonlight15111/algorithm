package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 〉
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 原题：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author Moonlight
 * @date 2020/8/4 18:14
 */
public class MergeTwoAscSortLists {

    public static void main (String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode newHead = mergeTwoLists(head1, head2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return newHead.next;
    }
}
