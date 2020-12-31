package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/linked-list-components/
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 * 输入: head: 0->1->2->3   G = [0, 1, 3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回2。
 *
 * 输入: head: 0->1->2->3->4   G = [0, 3, 1, 4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 *
 * @author Moonlight
 * @date 2020/12/31 17:31
 */
public class NumComponents {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        int[] arr = {0, 1, 2};
        System.out.println(numComponents(head, arr));
    }

    public static int numComponents(ListNode head, int[] G) {
        // 数组的数倒入List，循环链表，找组件的尾节点
        List<Integer> list = new ArrayList<>();
        for (int aG : G) {
            list.add(aG);
        }

        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur.val) && (cur.next == null || !list.contains(cur.next.val))) {
                res++;
            }
            cur = cur.next;
        }

        return res;
    }
}
