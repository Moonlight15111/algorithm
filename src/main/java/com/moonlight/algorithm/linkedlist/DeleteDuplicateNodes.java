package com.moonlight.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 来源: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author Moonlight
 * @date 2020/11/21 09:46
 */
public class DeleteDuplicateNodes {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);

        head = deleteDuplicateNoSort(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node deleteDuplicateNoSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        Node cur1 = head;
        while (cur1.next != null) {
            Node cur2 = cur1.next;
            if (set.add(cur2.val)) {
                cur1 = cur1.next;
            } else {
                cur1.next = cur1.next.next;
            }
        }
        cur1.next = null;
        return head;
    }

    public static Node deleteDuplicatesSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    private static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

}
