package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * @author Moonlight
 * @date 2020/12/30 16:01
 */
public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtHead( 2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtHead(5);
        list.get(5);
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);

//        ListNode head = list.getHead();
//        while (head != null) {
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
//
//        System.out.println("=============================");
//        System.out.println(list.get(1));
//        list.deleteAtIndex(1);
//
//        head = list.getHead();
//        while (head != null) {
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
//        System.out.println("=============================");
//        System.out.println(list.get(1));
    }

    private ListNode head;
    private ListNode tail;
    private List<ListNode> list;
    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        list = new ArrayList<>();
    }

    public ListNode getHead() {
        return head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        return index < 0 || index >= list.size() || list.get(index) == null ? -1 : list.get(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (list.size() == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        list.add(0, node);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (list.size() == 0) {
            addAtHead(val);
        } else {
            ListNode node = new ListNode(val);

            tail.next = node;
            tail = node;

            list.add(node);
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > list.size()) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
        } else if (index == list.size()) {
            addAtTail(val);
        } else {
            ListNode node = new ListNode(val);
            ListNode cur = head, prev = null;
            int i = 0;
            while (cur != null && i < index) {
                i++;
                prev = cur;
                cur = cur.next;
            }
            if (prev != null && cur != null) {
                prev.next = node;
                node.next = cur;
            }
            list.add(index, node);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= list.size() || index < 0 || list.size() == 0) {
            return;
        }
        list.remove(index);
        if (index == 0) {
            head = head.next;
        } else {
            ListNode cur = head, prev = null;
            int i = 0;
            while (cur != null && i < index) {
                i++;
                prev = cur;
                cur = cur.next;
            }
            if (prev != null && cur != null) {
                prev.next = cur.next;
            }
        }
    }
}
