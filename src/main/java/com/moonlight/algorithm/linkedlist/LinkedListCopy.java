package com.moonlight.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LinkedListCopy
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/5 21:16
 * @Version V1.0
 **/
public class LinkedListCopy {

    public static void main(String[] args){
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.rand = node2;
        node3.rand = head;
        node4.rand = node5;

        print(head);
        System.out.println("    ");
        print(copyList(head));
    }

    public static void print(Node head){
        while (head != null) {
            System.out.print("val: " + head.val + " - rand: " + (head.rand == null ? null : head.rand.val) + " , ");
            head = head.next;
        }
    }

    static class Node{
        private int val;
        private Node next;
        private Node rand;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node copyList(Node head){
        Map<Node, Node> record = new HashMap<>();
        Node current = head;
        while (current != null) {
            record.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            record.get(current).next = record.get(current.next);
            record.get(current).rand = record.get(current.rand);
            current = current.next;
        }
        return record.get(head);
    }
}
