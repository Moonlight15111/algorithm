package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/odd-even-linked-list/
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author Moonlight
 * @date 2020/12/25 17:54
 */
public class OddEvenList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = oddEvenList(head);
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 双指针，分别扫描奇数位和偶数位结点
        ListNode oddP = head;
        ListNode evenP = head.next;
        ListNode evenHead = head.next;

        while (evenP != null && evenP.next != null) {
            oddP.next = evenP.next;
            oddP = oddP.next;
            evenP.next = evenP.next.next;
            evenP = evenP.next;
        }
        oddP.next = evenHead;

        return head;
    }

}
