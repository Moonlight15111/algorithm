package com.moonlight.algorithm.linkedlist;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * @author Moonlight
 * @date 2020/11/21 17:21
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        Node headA = new Node(7);
        headA.next = new Node(2);
        headA.next.next = new Node(4);
        headA.next.next.next = new Node(3);

        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(4);

        Node headC = addTwoNumbers(headA, headB);
        while (headC != null) {
            System.out.println(headC.val);
            headC = headC.next;
        }
    }

    public static Node addTwoNumbers(Node headA, Node headB) {
        // 两个栈，每个栈存一个链表
        // 同步弹出，低位先加，记录进位
        Stack<Integer> stackA = new Stack<>(), stackB = new Stack<>();
        Node cur = headA;
        while (cur != null) {
            stackA.push(cur.val);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            stackB.push(cur.val);
            cur = cur.next;
        }
        int numA = 0, numB = 0, res = 0, ca = 0;
        Node node = null, prev = null;
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            numA = stackA.isEmpty() ? 0 : stackA.pop();
            numB = stackB.isEmpty() ? 0 : stackB.pop();
            res = numA + numB + ca;
            prev = node;
            node = new Node(res % 10);
            node.next = prev;
            ca = res / 10;
        }
        if (ca == 1) {
            prev = node;
            node = new Node(1);
            node.next = prev;
        }
        return node;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) { this.val = val; };
    }

}
