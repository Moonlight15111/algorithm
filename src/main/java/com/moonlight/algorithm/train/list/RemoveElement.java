package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/6/17 15:58
 */
public class RemoveElement {

    public ListNode removeElementsSentinel(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode prev = sentinel, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }

    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head.next = removeElementsRecursion(head.next, val);
            return head.next;
        } else {
            head.next = removeElementsRecursion(head.next, val);
            return head;
        }
    }

}
