package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/insertion-sort-list/
 * 对链表进行插入排序
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author Moonlight
 * @date 2020/12/28 15:46
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = insertionSortList(head);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static ListNode insertionSortList222(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 使用哑结点存储已经排好序的结点，每次都拿所有已经排好序的结点与未排序的结点对比
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode next, cur;
        while (head != null) {
            next = head.next;
            cur = dummy;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 计算链表长度  2. 将链表打乱放入数组中   3. 对数组进行插入排序  4. 数组重新组织成链表
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode[] arr = new ListNode[len];
        cur = head;
        ListNode next;
        len = 0;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            arr[len++] = cur;
            cur = next;
        }

        for (int i = 1; i < len; i++) {
            int j = i;
            while (j - 1 >= 0 && arr[j - 1].val > arr[j].val ) {
                cur = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = cur;
                j--;
            }
        }

        head = arr[0];
        cur = head;
        for (int i = 1; i < len; i++) {
            cur.next = arr[i];
            cur = cur.next;
        }

        return head;
    }

}
