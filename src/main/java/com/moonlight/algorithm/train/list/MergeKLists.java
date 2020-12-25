package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * @author Moonlight
 * @date 2020/12/24 17:33
 */
public class MergeKLists {

    public ListNode mergeKLists222(ListNode[] lists) {
        return mergeKLists222(lists, 0, lists.length - 1);
    }

    public  ListNode mergeKLists222(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoAscSortList(mergeKLists222(lists, left, mid), mergeKLists222(lists, mid + 1, right));
    }

    public ListNode mergeTwoAscSortList(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (a != null && b != null) {
            if (a.val > b.val) {
                cur.next = b;
                b = b.next;
            } else {
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;
        }

        if (a != null) {
            cur.next = a;
        };

        if (b != null) {
            cur.next = b;
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 能过，但是没什么技术含量
        List<ListNode> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node);
                node = node.next;
            }
        }
        list.sort((l1, l2) -> l1.val < l2.val ? -1 : (l1.val == l2.val ? 0 : 1));
        for (int i = 0, size = list.size(); i < size; i++) {
            list.get(i).next = i + 1 >= size ? null : list.get(i + 1);
        }
        return list.size() > 0 ? list.get(0) : null;
    }

}
