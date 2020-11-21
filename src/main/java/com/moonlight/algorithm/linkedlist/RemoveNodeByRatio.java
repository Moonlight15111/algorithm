package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/11/21 10:09
 */
public class RemoveNodeByRatio {

    public static Node removeNodeByRatio(Node head, int a, int b) {
        if (head == null || a < 1 || b < 0 || a > b) {
            return head;
        }
        int length = 0;
        Node cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int ceil = (int) Math.ceil( a * length / b);

        if (ceil == 1) {
            return head.next;
        }

        if (ceil <= 0) {
            return head;
        }

        cur = head;
        while (--ceil != 1) {
            ceil--;
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }


    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
