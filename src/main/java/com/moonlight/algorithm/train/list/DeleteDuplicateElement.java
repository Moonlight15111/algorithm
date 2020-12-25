package com.moonlight.algorithm.train.list;

import java.util.HashSet;
import java.util.Set;
/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author Moonlight
 * @date 2020/12/25 16:42
 */
public class DeleteDuplicateElement {
    public static ListNode deleteDuplicatesSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
