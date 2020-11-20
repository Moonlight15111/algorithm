package com.moonlight.algorithm.linkedlist;

import com.moonlight.algorithm.train.ListNode;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *  输入两个链表，找出它们的第一个公共节点。
 *  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *  输出：Reference of the node with value = 8
 *  输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 *  从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * @author Moonlight
 * @date 2020/11/20 15:40
 */
public class TwoListIntersectionNode {

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
        ListNode current1 = headA, current2 = headB;
        int length = 0;
        // 1.计算高度差
        while (current1.next != null) {
            length++;
            current1 = current1.next;
        }
        while (current2.next != null) {
            length--;
            current2 = current2.next;
        }
        // 如果最终两个不相等，那么说明他们其实是没有相交的
        if (!current1.equals(current2)) {
            return null;
        }
        // 如果length > 0 ，那么说明 A 比 B长
        current1 = length > 0 ? headA : headB;
        current2 = current1.equals(headA) ? headB : headA;
        // 也有可能出现负数情况
        length = Math.abs(length);

        // 2.从高度差开始的地方同时出发，第一个相同的点即为相交点
        while (length != 0) {
            length--;
            current1 = current1.next;
        }
        while (!current1.equals(current2)) {
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
