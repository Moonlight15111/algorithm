package com.moonlight.algorithm.train.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/LwUNpT/
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * 输入: root = [2,1,3]  输出: 1
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]  输出: 7
 *
 * @author Moonlight
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.left.left = new TreeNode(4);
        b.right = new TreeNode(3);
        b.right.left = new TreeNode(5);
        b.right.left.left = new TreeNode(7);
        b.right.right = new TreeNode(6);

        System.out.println(findBottomLeftValue(a));
        System.out.println(findBottomLeftValue(b));
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode poll = null;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
        }
        return poll.val;
    }

}
