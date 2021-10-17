package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/SLwz0R/
 *
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2  输出：[1,2,3,5]
 *
 * 输入：head = [1], n = 1  输出：[]
 *
 * 输入：head = [1,2], n = 1  输出：[1]
 *
 * @ClassName RemoveNthFromEnd
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/17 12:37
 * @Version V1.0
 **/
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);

        ListNode listNode = removeNthFromEnd(h, 2);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode c = head, ans = new ListNode();
        ans.next = c;
        while (c != null) {
            len++;
            c = c.next;
        }
        c = ans;
        for (int i = 1; i < len - n + 1; i++) {
            c = c.next;
        }
        c.next = c.next.next;
        
        return ans.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}
