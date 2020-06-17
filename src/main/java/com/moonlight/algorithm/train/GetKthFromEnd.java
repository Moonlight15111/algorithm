package com.moonlight.algorithm.train;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。〉
 * 给定一个链表: 1->2->3->4->5, 和 k = 2. 返回链表 4->5.
 * 原题: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author Moonlight
 * @date 2020/6/17 9:59
 */
public class GetKthFromEnd {

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(getKthFromEnd(head, 2).val);

    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        Map<Integer, ListNode> record = new HashMap<>();

        int index = 1;
        ListNode node = head;
        while (node != null) {
            record.put(index++, node);
            node = node.next;
        }
        return record.get(index - k);
    }
}
