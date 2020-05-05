package com.moonlight.algorithm.linkedlist;

/**
 * @ClassName LinkedListMidNode
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/5 13:22
 * @Version V1.0
 **/
public class LinkedListMidNode<T> {

    public SingleNode<T> midOrUpMidNode(SingleNode<T> headNode) {
        if (headNode == null || headNode.next == null || headNode.next.next == null) {
            return headNode;
        }
        SingleNode<T> slow = headNode.next, fast = headNode.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public SingleNode<T> midOrDownMidNode(SingleNode<T> headNode) {
        if(headNode == null || headNode.next == null){
            return headNode;
        }
        SingleNode<T> slow = headNode.next, fast = headNode.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public SingleNode<T> midOrUpMidPreNode(SingleNode<T> headNode) {
        if (headNode == null || headNode.next == null || headNode.next.next == null) {
            return headNode;
        }
        SingleNode<T> slow = headNode, fast = headNode.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public SingleNode<T> midOrDownMidPreNode(SingleNode<T> headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        SingleNode<T> slow = headNode, fast = headNode.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
