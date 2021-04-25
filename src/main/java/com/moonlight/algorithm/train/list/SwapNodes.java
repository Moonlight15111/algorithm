package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 *
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 * 输入：head = [1,2,3,4,5], k = 2  输出：[1,4,3,2,5]
 *
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 *
 * 输入：head = [1], k = 1       输出：[1]
 *
 * 输入：head = [1,2], k = 1     输出：[2,1]
 *
 * 输入：head = [1,2,3], k = 2   输出：[1,2,3]
 *
 * @author Moonlight
 * @date 2021/4/25 18:08
 */
public class SwapNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        head = list(head, 2);
        head = doublePtr(head, 2);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static ListNode doublePtr(ListNode head, int k) {
        ListNode slow = head, fast = head, cur = head;
        int c = 1;
        while (cur != null && cur.next != null) {
            if (c < k) {
                fast = fast.next;
            } else {
                slow = slow.next;
            }
            c++;
            cur = cur.next;
        }
        c = slow.val;
        slow.val = fast.val;
        fast.val = c;

        return head;
    }

    public static ListNode list(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            list.add(cur);
            cur = next;
        }

        cur = list.get(k - 1);
        list.set(k - 1, list.get(list.size() - k));
        list.set(list.size() - k, cur);

        cur = list.get(0);
        next = cur;
        for (int i = 1; i < list.size(); i++) {
            next.next = list.get(i);
            next = next.next;
        }
        return cur;
    }

}
