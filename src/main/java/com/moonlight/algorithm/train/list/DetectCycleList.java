package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中
 * 说明：不允许修改给定的链表。
 * @author Moonlight
 * @date 2020/12/25 15:05
 */
public class DetectCycleList {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode slow = head.next, fast = head.next.next;
        while (!slow.equals(fast)) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (!slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
