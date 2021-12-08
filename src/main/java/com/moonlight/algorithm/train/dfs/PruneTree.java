package com.moonlight.algorithm.train.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/pOCWxh/
 *
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 *
 * 输入: [1,null,0,0,1]  输出: [1,null,0,null,1]
 *
 * 输入: [1,0,1,0,0,0,1]  输出: [1,null,1,null,1]
 *
 * 输入: [1,1,0,1,1,0,1,0]  输出: [1,1,0,1,1,null,1]
 *
 * @author Moonlight
 */
public class PruneTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(0);
        a.right.left = new TreeNode(0);
        a.right.right = new TreeNode(1);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(0);
        b.left.left = new TreeNode(0);
        b.left.right = new TreeNode(0);
        b.right = new TreeNode(1);
        b.right.left = new TreeNode(0);
        b.right.right = new TreeNode(1);

        TreeNode node = pruneTree(a);
        StringBuilder sb = new StringBuilder();
        print(node, sb);
        System.out.println(sb);

        node = pruneTree(b);
        sb = new StringBuilder();
        print(node, sb);
        System.out.println(sb);
    }

    public static void print(TreeNode root, StringBuilder sb) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            sb.append(poll.val).append(", ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1 ? root : null;
        }
        return dfs(root) ? root : null;
    }

    private static boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left), right = dfs(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
    }

}
