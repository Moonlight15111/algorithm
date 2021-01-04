package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/merge-in-between-linked-lists/
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 * 请你返回结果链表的头指针。
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 *
 * @author Moonlight
 * @date 2021/1/4 10:18
 */
public class MergeInBetweenList {

    public static void main(String[] args) {

    }

    public static ListNode mergeInBetween222(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cur = list1, prev = dummy, cur2 = list2;
        int len = 0;

        return dummy.next;
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cur = list1, prevA = dummy;
        dummy.next = list1;
        int len = 0;
        while (cur != null) {
            if (len + 1 == a) {
                prevA = cur;
            }
            if (len == b) {
                break;
            }
            len++;
            cur = cur.next;
        }
        prevA.next = list2;
        ListNode c2 = list2;
        while (c2.next != null) {
            c2 = c2.next;
        }
        c2.next = cur == null || cur.next == null ? cur : cur.next;

        return dummy.next;
    }

}
