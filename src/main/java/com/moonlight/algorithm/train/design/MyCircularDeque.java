package com.moonlight.algorithm.train.design;

/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *
 */
public class MyCircularDeque {

    public static void main(String[] args) {
        // 设置容量大小为3
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        // true
        System.out.println(circularDeque.insertFront(5));
        // 5
        System.out.println(circularDeque.getFront());
        // false
        System.out.println(circularDeque.isEmpty());
        // true
        System.out.println(circularDeque.deleteFront());
        // true
        System.out.println(circularDeque.insertLast(3));
        // 3
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(7));
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertLast(4));
        System.out.println(circularDeque.isEmpty());
//        // 返回 true
//        System.out.println(circularDeque.insertLast(1));
//        // 返回 true
//        System.out.println(circularDeque.insertLast(2));
//        // 返回 true
//        System.out.println(circularDeque.insertFront(3));
//        // 已经满了，返回 false
//        System.out.println(circularDeque.insertFront(4));
//        // 返回 2
//        System.out.println(circularDeque.getRear());
//        // 返回 true
//        System.out.println(circularDeque.isFull());
//        // 返回 true
//        System.out.println(circularDeque.deleteLast());
//        // 返回 true
//        System.out.println(circularDeque.insertFront(4));
//        // 返回 4
//        System.out.println(circularDeque.getFront());
    }

    private Node h, t;
    private int s, c;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        s = k;
        c = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (s == c) {
            return false;
        }
        Node head = h;
        Node node = new Node(value);
        h = node;
        if (head == null) {
            t = node;
        } else {
            head.p = node;
            node.n = head;
        }
        c++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (s == c) {
            return false;
        }
        Node tail = t;
        Node node = new Node(value);
        t = node;
        if (tail == null) {
            h = node;
        } else {
            tail.n = node;
            node.p = tail;
        }
        c++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (h == null) {
            return false;
        }
        if (h == t) {
            t = null;
        }
        Node head = h;
        Node next = h.n;
        head.n = null;
        if (next != null) {
            next.p = null;
        }
        h = next;
        c--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (t == null) {
            return false;
        }
        if (t == h) {
            h = null;
        }
        Node prev = t.p;
        if (prev != null) {
            prev.n = null;
        }
        t = prev;
        c--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return h == null ? -1 : h.v;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return t == null ? -1 : t.v;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return c == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return s == c;
    }

    private static class Node {
        int v;
        Node n;
        Node p;
        Node(int val) {
            v = val;
        }
    }

}
