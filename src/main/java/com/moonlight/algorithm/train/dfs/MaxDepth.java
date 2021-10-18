package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        System.out.println(maxDepth(r));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int r = 1;
        if (root.left != null || root.right != null) {
            r += Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return r;
    }

}
