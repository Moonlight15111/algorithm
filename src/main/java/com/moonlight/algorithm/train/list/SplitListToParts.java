package com.moonlight.algorithm.train.list;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 *
 * 输入: root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释: 输入输出各部分都应该是链表，而不是数组。例如, 输入的结点 root 的 val= 1, root.next.val = 2, root.next.next.val = 3, 且 root.next.next.next = null。
 *       第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * @author Moonlight
 * @date 2020/12/31 9:39
 */
public class SplitListToParts {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        // 3
        ListNode[] listNodes = splitListToParts(head, 5);
        for (ListNode node : listNodes) {
            System.out.println(node == null ? null : node.val);
        }

    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        // 算出链表长度，计算分成 k 组能分多少组余下多少个，循环链表进行分组，对于余下的每组最多只能分得一个
        ListNode[] res = new ListNode[k];
        Arrays.fill(res, null);

        if (root == null || root.next == null) {
            res[0] = root;
            return res;
        }

        int len = 0;

        ListNode cur = root, next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int re = len % k, quo = len / k;

        cur = root;
        int i = 1, index = 0;
        while (cur != null) {
            res[index++] = cur;
            while (i < quo) {
                i++;
                cur = cur.next;
            }
            if (re > 0 && i <= quo) {
                re--;
                cur = cur.next;
            }
            next = cur.next;
            cur.next = null;
            cur = next;
            i = 1;
        }

        return res;
    }

}
