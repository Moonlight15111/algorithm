package com.moonlight.algorithm.train.list;

/**
 * https://leetcode-cn.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 *
 * 输入：head = [1,3,4,7,1,2,6]  输出：[1,3,4,1,2,6]
 *
 * 输入：head = [1,2,3,4]  输出：[1,2,4]
 *
 * 输入：head = [2,1]  输出：[2]
 *
 * @author Moonlight
 */
public class DeleteMiddle {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(7);
        a.next.next.next.next = new ListNode(1);
        a.next.next.next.next.next = new ListNode(2);
        a.next.next.next.next.next.next = new ListNode(6);

        ListNode node = deleteMiddle(a);
        printNode(node);

        a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);

        node = deleteMiddle(a);
        printNode(node);

        a = new ListNode(2);
        a.next = new ListNode(1);

        node = deleteMiddle(a);
        printNode(node);

    }

    private static void printNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next, prev = head;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

}