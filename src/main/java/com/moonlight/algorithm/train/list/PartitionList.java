package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/partition-list/
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @author Moonlight
 * @date 2020/12/28 17:09
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode listNode = partition(head, 3);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 分成小于、大于等于两个链表    2. 合并两个
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode moreDummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy, next, more = moreDummy;
        while (head != null) {
            next = head.next;

            head.next = null;
            if (head.val < x) {
                cur.next = head;
                cur = cur.next;
            } else {
                more.next = head;
                more = more.next;
            }

            head = next;
        }

        cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = moreDummy.next;
        return dummy.next;
    }

}
