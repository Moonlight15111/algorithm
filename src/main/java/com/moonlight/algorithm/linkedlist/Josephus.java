package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/11/21 11:16
 */
public class Josephus {

    public static void main (String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head;

        Node josephus = josephus(head, 2);
        while (josephus != null) {
            System.out.println(josephus.val);
            josephus = josephus.next;
        }
    }

    public static Node josephus(Node head, int m) {
        if (head == null || head.next == null || m  < 1) {
            return head;
        }
        // 先找到最后一个节点
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        int count = 0;
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            // 不管怎么样head 都要在 last前一个位置上
            head = last.next;
        }
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
