package com.moonlight.algorithm.train.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/even-odd-tree/
 *
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *    1. 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 *    2. 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 *    3. 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]  输出：true
 * 解释：每一层的节点值分别是：
 *       0 层：[1]
 *       1 层：[10,4]
 *       2 层：[3,7,9]
 *       3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 *
 * 输入：root = [5,4,2,3,3,7]  输出：false
 * 解释：每一层的节点值分别是：
 *       0 层：[5]
 *       1 层：[4,2]
 *       2 层：[3,3,7]
 *       2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 *
 * @author Moonlight
 */
public class IsEvenOddTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(10);
        a.left.left = new TreeNode(3);
        a.left.left.left = new TreeNode(12);
        a.left.left.right = new TreeNode(8);
        a.right = new TreeNode(4);
        a.right.left = new TreeNode(7);
        a.right.right = new TreeNode(9);
        a.right.left.left = new TreeNode(6);
        a.right.right.right = new TreeNode(2);

        System.out.println(isEvenOddTree(a));

        TreeNode b = new TreeNode(5);
        b.left = new TreeNode(4);
        b.left.left = new TreeNode(3);
        b.left.right = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(7);

        System.out.println(isEvenOddTree(b));

        TreeNode c = new TreeNode(1);

        System.out.println(isEvenOddTree(c));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if ((root.val & 1) != 1) {
            return false;
        }
        int level = 0, size, prev;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode poll;
        while (!queue.isEmpty()) {
            size = queue.size();
            prev = -1;
            for (int i = 0; i < size; i++) {
                poll = queue.poll();
                if ((level & 1) == (poll.val & 1)) {
                    return false;
                }
                if ((level & 1) == 1 && prev != -1 && prev <= poll.val) {
                    return false;
                }
                if ((level & 1) == 0 && prev != -1 && prev >= poll.val) {
                    return false;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                prev = poll.val;
            }
            level++;
        }

        return true;
    }

}