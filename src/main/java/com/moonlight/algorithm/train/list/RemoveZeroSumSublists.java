package com.moonlight.algorithm.train.list;

import java.util.HashMap;
import java.util.Map;
/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题: https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的
 * 序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。你可以返回任何满足题目要求的答案。
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 *
 *  输入：head = [1,2,3,-3,-2]
 *  输出：[1]
 *
 * @author Moonlight
 * @date 2021/1/5 15:10
 */
public class RemoveZeroSumSublists {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode node = removeZeroSumSublists(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head.next == null) {
            return head.val == 0 ? null : head;
        }
        // 如果之前有和值为0的会互相抵消掉，即同一个sum值可能出现多次，但在hash表中只会记录最后出现的位置
        // 假设节点 i 的sum值在 j 节点再次出现，则 i + 1 到 j 之间的和值为0
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode cur = dummy;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }
        sum = 0;
        cur = dummy;
        while (cur != null) {
            sum += cur.val;
            cur.next = map.get(sum) != null ? map.get(sum).next : cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }

}
