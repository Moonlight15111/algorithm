package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈反转从位置 m 到 n 的链表〉
 * https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * @author Moonlight
 * @date 2020/6/15 18:11
 */
public class ReverseBetween {

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode test = head;
        while (test != null) {
            System.out.print(test.val + ", ");
            test = test.next;
        }
        System.out.println("");
        ListNode t2 = reverseBetween(head, 3, 5);
        while (t2 != null) {
            System.out.print(t2.val + ", ");
            t2 = t2.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        };
        if (m == 1) {
            // base case 在m == 1 时 相当于反转前n个元素
            return reverseN(head, n);
        }
        // 递归到反转起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    static ListNode successor = null;
    public static ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            // 在 n == 1时，即取到了要求的最后一个node，记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode res = reverseN(head.next, n - 1);
        // 反转子节点的子节点的指向关系
        head.next.next = head;
        // 让反转之后的 head 节点和 n + 1 节点连起来
        head.next = successor;

        return res;
    }

    private ListNode reverseSingleList(ListNode head){
        if (head.next == null) {
            return head;
        }
        ListNode res = reverseSingleList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
