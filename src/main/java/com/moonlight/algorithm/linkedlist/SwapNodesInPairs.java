package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 输入：head = []
 * 输出：[]
 * 来源: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author Moonlight
 * @date 2020/11/21 15:20
 */
public class SwapNodesInPairs {

    public static void main (String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = swapNodesInPairs(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node swapNodesInPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 两两交换 - 即 第 i 个需要指向 第 i + 2 个，第 i + 1 个指向第 i 个
        // 使用递归两两分开  将第 i 个指向第 i + 2个，再将i + 1 个指向第 i 个
        Node next = head.next;
        head.next = swapNodesInPairs(next.next);
        next.next = head;
        return next;
    }

    private static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

}
