package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/3u1WK4/
 * <p>
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * @ClassName GetIntersectionNode
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/16 14:22
 * @Version V1.0
 **/
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len = 0;
        ListNode f = headA, s = headB;
        while (f.next != null) {
            f = f.next;
            len++;
        }
        while (s.next != null) {
            s = s.next;
            len--;
        }
        if (!f.equals(s)) {
            return null;
        }
        f = len < 0 ? headB : headA;
        s = f.equals(headB) ? headA : headB;

        len = Math.abs(len);
        while (len != 0) {
            f = f.next;
            len--;
        }
        while (!f.equals(s)) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
