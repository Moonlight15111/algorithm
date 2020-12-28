package com.moonlight.algorithm.train.list;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/sort-list/
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * @author Moonlight
 * @date 2020/12/28 11:32
 */
public class AscSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

//        ListNode listNode = sortList(head);
//        while (listNode != null) {
//            System.out.print(listNode.val + ", ");
//            listNode = listNode.next;
//        }

        ListNode listNode = sortList222(head);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static ListNode sortList222(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // N*logN  归并排序 --> 先找中点
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 中点断链
        ListNode right = slow.next;
        slow.next = null;
        // 左右递归有序合并
        return merge(sortList222(head), sortList222(right));
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode tmp = new ListNode(Integer.MIN_VALUE);
        ListNode cur = tmp;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return tmp.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        list.sort(Comparator.comparingInt(a -> a.val));

        ListNode newHead = list.get(0);
        list.remove(0);

        cur = newHead;
        for (ListNode listNode : list) {
            cur.next = listNode;
            listNode.next = null;
            cur = listNode;
        }

        return newHead;
    }

}