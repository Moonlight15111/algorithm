package com.moonlight.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 来源: https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @author Moonlight
 * @date 2020/11/21 16:04
 */
public class CopyRandomList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node2;
        node3.random = head;
        node4.random = node5;

        print(copyRandomList2(head));
    }

    public static void print(Node head){
        while (head != null) {
            System.out.println("val: " + head.val + " - rand: " + (head.random == null ? null : head.random.val) + " ");
            head = head.next;
        }
    }

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        // 使用原来的链表来承载深拷贝出来的结点数据
        Node cur = head, next, copy;
        while (cur != null) {
            next = cur.next;

            copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;

            cur = next;
        }
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        cur = head;
        Node newHead = cur.next;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next == null ? null : next.next;

            cur = cur.next;
        }
        return newHead;
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> mapping = new HashMap<>();

        Node cur = head;

        while (cur != null) {
            mapping.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node node = mapping.get(cur);
            node.next = mapping.get(cur.next);
            node.random = mapping.get(cur.random);

            cur = cur.next;
        }
        return mapping.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

}
