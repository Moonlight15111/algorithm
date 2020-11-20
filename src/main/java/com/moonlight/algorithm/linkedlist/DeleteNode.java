package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * 来源: https://leetcode-cn.com/problems/delete-middle-node-lcci/
 * @author Moonlight
 * @date 2020/11/20 18:00
 */
public class DeleteNode {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        deleteNode(node.next.next);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
