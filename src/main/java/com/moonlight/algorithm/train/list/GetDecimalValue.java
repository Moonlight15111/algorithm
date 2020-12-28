package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * @author Moonlight
 * @date 2020/12/28 10:46
 */
public class GetDecimalValue {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            res <<= 1;
            res += cur.val;
            cur = cur.next;
        }

        return res;
    }

}
