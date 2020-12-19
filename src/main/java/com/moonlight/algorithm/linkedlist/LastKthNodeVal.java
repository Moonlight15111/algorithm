package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 来源: https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * @author Moonlight
 * @date 2020/11/20 18:16
 */
public class LastKthNodeVal {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(kthToLast(head, 3));
    }

    public static int kthToLast(Node head, int k) {
        if (head == null || k < 1) {
            return 0;
        }

        // 快慢指针 - 间隔 K
        Node fast = head, slow = head;

        while (fast.next != null) {
            fast = fast.next;
            if (k == 0) {
                slow = slow.next;
            } else {
                k--;
            }
        }

        if (k != 0) {
            return head.val;
        } else {
            return slow.next.val;
        }
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
