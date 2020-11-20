package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定两个链表头指针，打印两个链表公共部分
 * @author Moonlight
 * @date 2020/11/20 16:14
 */
public class PrintCommonPart {

    public static void main(String[] args) {
        Node intersection = new Node(8);
        intersection.next = new Node(4);
        intersection.next.next = new Node(5);

        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = intersection;

        Node headB = new Node(5);
        headB.next = new Node(0);
        headB.next.next = new Node(1);
        headB.next.next.next = intersection;

        printCommonPart(headA, headB);
    }

    public static void printCommonPart(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return;
        }
        Node cur1 = headA, cur2 = headB;

        while (cur1 != null && cur2 != null) {
            if (cur1.val == cur2.val) {
                System.out.println(cur1.val);
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (cur1.val > cur2.val) {
                cur2 = cur2.next;
            } else {
                cur1 = cur1.next;
            }
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
