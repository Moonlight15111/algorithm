package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释: 向右旋转 1 步: 5->1->2->3->4->NULL, 向右旋转 1 步: 5->1->2->3->4->NULL
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释: 向右旋转 1 步: 2->0->1->NULL    向右旋转 2 步: 1->2->0->NULL
 *       向右旋转 3 步: 0->1->2->NULL    向右旋转 4 步: 2->0->1->NULL
 *
 *
 * @author Moonlight
 * @date 2020/12/25 15:12
 */
public class RotateRightList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        ListNode res = rotateRight(head, 2);
        ListNode res = rotateRight221(head, 2);
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }

    public static ListNode rotateRight221(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 链表先成环  然后找到新的头结点，断掉，重连
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        int m = k % len;
        if (m == 0) {
            return head;
        }

        tail.next = head;
        ListNode newHead;
        tail = head;
        // 尾 = len - m - 1
        for (int i = 0; i < len - m - 1; i++) {
            tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;

        return newHead;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先求出链表的长度Len
        int len = 0;
        ListNode lenNode = head;
        while (lenNode != null) {
            len++;
            lenNode = lenNode.next;
        }
        // 然后K取余长度Len得到M，M为0时，直接返回，否则往下走直到M为0
        int m = k % len;
        // 在M为0的位置打断链表
        if (m == 0) {
            return head;
        }
        ListNode left = head, right = head;
        while (m != 0) {
            right = right.next;
            m--;
        }
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        ListNode res = left.next;
        right.next = head;
        left.next = null;

        return res;
    }
}
