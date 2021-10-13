package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/aMhZSa/
 *
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 * 输入: head = [1,2,3,3,2,1]  输出: true
 *
 * @ClassName isPalindrome
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/13 21:56
 * @Version V1.0
 **/
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(2);
        h.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(h));
    }

    public static boolean isPalindrome(ListNode head) {
//        LinkedList<Integer> q = new LinkedList<>();
//        while (head != null) {
//            q.add(head.val);
//            head = head.next;
//        }
//        while (q.size() > 1) {
//            if (!q.pollFirst().equals(q.pollLast())) {
//                return false;
//            }
//        }
//        return true;
        // 先找到中间节点
        ListNode f = head, s = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        // 反转链表
        ListNode c = s.next, n = null;
        while(c != null) {
            n = c.next;
            c.next = s;
            s = c;
            c = n;
        }
        while(head != s) {
            if(head.val != s.val) {
                return false;
            }
            if(head.next == s) {
                return true;
            }
            s = s.next;
            head = head.next;
        }
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}