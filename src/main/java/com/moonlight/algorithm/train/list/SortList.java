package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/7WHec2/
 *
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 输入：head = [4,2,1,3]  输出：[1,2,3,4]
 *
 * 输入：head = [-1,5,3,4,0]  输出：[-1,0,3,4,5]
 *
 */
public class SortList {

    public static void main(String[] args) {
        ListNode h = new ListNode(4);
        h.next = new ListNode(2);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(3);

        ListNode listNode = sortList(h);
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode c = head, n;
        while (c != null) {
            n = c.next;
            c.next = null;
            list.add(c);
            c = n;
        }
        list.sort(Comparator.comparingInt(a -> a.val));

        head = list.get(0);
        c = head;
        for (int i = 1; i < list.size(); i++) {
            c.next = list.get(i);
            c = c.next;
        }
        return head;
    }

}