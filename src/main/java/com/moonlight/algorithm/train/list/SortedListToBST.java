package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。本题中，一个高度平衡二叉树是指一个二叉树每个节点
 * 的左右两个子树的高度差的绝对值不超过 1。
 * 给定的有序链表： [-10, -3, 0, 5, 9]
 * 一个可能的答案是：[0, -3, 9, -10, null, 5]
 * @author Moonlight
 * @date 2020/12/30 11:43
 */
public class SortedListToBST {

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 取中点，断链，递归左右
        // 考虑到头结点，都从head出发
        ListNode slow = head, fast = head, slowPre = slow;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

}
