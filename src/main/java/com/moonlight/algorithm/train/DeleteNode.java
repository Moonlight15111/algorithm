package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 返回删除后的链表的头节点。〉
 *  原题： https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author Moonlight
 * @date 2020/6/17 12:22
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode current = head;
        while (current.next != null && current.next.val != val) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }
}
