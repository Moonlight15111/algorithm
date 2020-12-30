package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * 输入的多级列表如下图所示：
 * 1---2---NULL
 * |
 * 3---NULL
 * @author Moonlight
 * @date 2020/12/30 17:14
 */
public class FlattenDoubleList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        head.next = n2;
        n2.prev = head;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n3.child = n7;
        n4.next = n5;
        n4.prev = n3;
        n5.next = n6;
        n5.prev = n4;
        n6.prev = n5;
        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n8.child = n11;
        n9.prev = n8;
        n9.next = n10;
        n11.next = n12;
        n12.prev = n11;

        Node flatten = flatten(head);
        while (flatten != null) {
            System.out.println(flatten.val);
            flatten = flatten.next;
        }

        Node h2 = new Node(1);
        h2.child = new Node(2);
        h2.child.child = new Node(3);

        Node fff = flatten(h2);
        while (fff != null) {
            System.out.println(fff.val);
            fff = fff.next;
        }
    }

    public static Node flatten222222(Node head) {
        if (head == null || (head.child == null && head.next == null)) {
            return head;
        }
        Node dummy = new Node();
        dummy.val = Integer.MIN_VALUE;
        dummy.next = head;
        dummy.child = null;
        dummy.prev = null;
        flattenDFS(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    public static Node flattenDFS(Node prev, Node cur) {
        if (cur == null) {
            return prev;
        }
        cur.prev = prev;
        prev.next = cur;
        Node next = cur.next;
        Node child = flattenDFS(cur, cur.child);
        cur.child = null;
        return flattenDFS(child, next);
    }


    public static Node flatten(Node head) {
        if (head == null || (head.child == null && head.next == null)) {
            return head;
        }
        // 分成三份: 左边  孩子  右边   发现有孩子，先处理孩子那一层的链，然后 父亲.next = 孩子  孩子.prev = 父亲  孩子.next = 父亲原本的next
        Node cur = head, next = null, child;
        while (cur != null) {
            next = cur.next;
            if (cur.child != null) {
                child = flatten(cur.child);
                child.prev = cur;
                cur.next = child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next = next;
                if (next != null) {
                    next.prev = child;
                }
                cur.child = null;
            }
            cur = next;
        }
        return head;
    }

}
