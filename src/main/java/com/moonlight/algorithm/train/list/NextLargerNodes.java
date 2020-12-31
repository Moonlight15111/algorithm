package com.moonlight.algorithm.train.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ...
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么
 * 就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1})
 * <p>
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * <p>
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 * @author Moonlight
 * @date 2020/12/31 12:23
 */
public class NextLargerNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);

        System.out.println(Arrays.toString(nextLargerNodes(head)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        if (head == null || head.next == null) {
            return new int[]{0};
        }
        // 先把值搞出来，按下标顺序压到栈里，碰到第一个比自己大的数就弹出
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int[] res = new int[list.size()];
        Arrays.fill(res, 0);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0, size = list.size(); i < size; i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }

        return res;
    }
}
